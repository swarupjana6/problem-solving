package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.PeakElement.peakElement;

@Log4j2
public class AllocateMinimumNoOfPages {

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40);
        int K = 2;

        log.info("Input: Books with pages {} | Students {} ", list, K);
        log.info("Output: Index of '{}' is {} ", K, getMinimumNoOfPages(list, K));
    }

    public static Integer getMinimumNoOfPages(List<Integer> list, Integer K) {
        if (K > list.size()) return -1;

        int maxInArray = peakElement(list);
        int sum = list.stream().reduce(0, Integer::sum);
        int answer = -1;

        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (isValid(list, K, maxInArray)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    private static boolean isValid(List<Integer> list, Integer k, Integer max) {
        int size = list.size();
        int student = 1;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += list.get(i);
            if (sum > max) {
                student++;
                sum = list.get(i);
            }
            if (student > k) return false;
        }

        return true;
    }
}
