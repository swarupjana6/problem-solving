package com.practice.problems.adityaverma.heap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Log4j2
public class ClosestPointToOrigin {

    public static void main(String[] args) {
        Integer[][] input = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int K = 2;
        log.info("Input: {} {}", input, K);
        log.info("Output: {}", sortMaxHeap(input, K));
    }

    /**
     * MAX HEAP is required since more frequent element at the top
     **/
    private static List<Position> sortMaxHeap(Integer[][] input, int k) {
        Comparator maxTop = Comparator.reverseOrder();
        PriorityQueue<Position> maxHeap = new PriorityQueue<>(maxTop);

        for (int i = 0; i < input.length; i++) {
            int x = input[i][0];
            int y = input[i][1];
            maxHeap.add(new Position(positionFromOrigin(x, y), new Pair(x, y)));

            while (maxHeap.size() > k) maxHeap.remove();
        }

        List<Position> answer = new ArrayList<>();
        answer.addAll(maxHeap);

        return answer;
    }

    private static int positionFromOrigin(int x, int y) {
        return x * x + y * y;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Position implements Comparable<Position> {

        private Integer distance;
        private Pair coordinates;

        @Override
        public int compareTo(Position withPair) {
            return this.distance.compareTo(withPair.getDistance());
        }

        @Override
        public String toString() {
            return "{ " + "distance=" + distance + "|" + coordinates + " }";
        }
    }
}
