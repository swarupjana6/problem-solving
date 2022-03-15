package com.practice.problems.adityaverma.stack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.practice.problems.adityaverma.stack.RainWaterTrapping.FirstSolution.solution1;
import static com.practice.problems.adityaverma.stack.RainWaterTrapping.SecondSolution.solution2;

@Log4j2
public class RainWaterTrapping {

    public static void main(String[] args) {
        var building1 = Arrays.asList(5, 6, 12, 10, 0, 0, 2, 0, 4, 3, 2, 1, 3, 9);
        var building2 = Arrays.asList(3, 0, 0, 2, 0, 4);
        var building3 = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        var building4 = Arrays.asList(0, 1, 0, 1, 0, 1, 0, 1);
        var building5 = Arrays.asList(0, 1, 0, 1, 0);
        var building6 = Arrays.asList(1, 0, 0, 0, 1);
        var building = building6;
        log.info("Input :: {}", building);
        call(building);
    }

    private static void call(List<Integer> building) {
        log.info("Total Water Trapped Online :: {}", solution1(building));
        log.info("Total Water Trapped Sweta's Solution :: {}", solution2(building));
    }

    class FirstSolution {

        public static Integer solution1(List<Integer> inputList) {
            var totalWater = 0;
            var maxRights = calculateMaxRights(inputList);
            var maxLefts = calculateMaxLefts(inputList);
            log.debug("msl {}",maxLefts);
            log.debug("msr {}",maxRights);
            for (int i = 0; i < inputList.size(); i++) {
                var element = inputList.get(i);
                var waterFilled = Math.min(maxLefts.get(i), maxRights.get(i)) - element;
                totalWater += waterFilled;
            }
            return totalWater;
        }

        private static List<Integer> calculateMaxRights(List<Integer> inputList) {
            var maxRight = inputList.get(inputList.size() - 1);
            var maxRights = new LinkedList<Integer>();
            for (int i = inputList.size() - 1; i >= 0; i--) {
                maxRight = Math.max(maxRight, inputList.get(i));
                maxRights.add(maxRight);
            }
            Collections.reverse(maxRights);
            return maxRights;
        }

        private static List<Integer> calculateMaxLefts(List<Integer> inputList) {
            var maxLeft = inputList.get(0);
            var maxLefts = new LinkedList<Integer>();
            for (int i = 0; i < inputList.size(); i++) {
                maxLeft = Math.max(maxLeft, inputList.get(i));
                maxLefts.add(maxLeft);
            }
            return maxLefts;
        }

    }

    class SecondSolution {

        public static Integer solution2(List<Integer> inputList) {
            var totalWater = 0;
            for (int i = 0; i < inputList.size(); i++) {
                boolean isLoopEnd = (i == inputList.size() - 1);
                if (isLoopEnd) continue;

                if (inputList.get(i + 1) <= inputList.get(i)) {
                    int maxIndex = maxIndex(i + 1, inputList);
                    if (maxIndex - i != 1) {
                        var min = Math.min(inputList.get(i), inputList.get(maxIndex));
                        for (int j = i + 1; j < maxIndex; j++) totalWater += Math.abs(min - inputList.get(j));
                        i = maxIndex - 1;
                    }
                }
                continue;
            }

            return totalWater;
        }

        private static Integer maxIndex(int i, List<Integer> inputList) {
            var max = inputList.get(i);
            var maxIndex = i;
            for (int j = i; j < inputList.size(); j++) {
                if (inputList.get(j) > max) {
                    max = inputList.get(j);
                    maxIndex = j;
                    break;
                }
            }
            return maxIndex;
        }
    }
}
