package com.practice.problems.adityavermapractice.slidingwindow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * <p>
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 * <p>
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 **/

@Log4j2
public abstract class MaximumOfAllSubArrays {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<Integer> maxOfAllSubArrays(List<Integer> numbers, Integer window);

    public void execute() {
        List<Integer> numbers = List.of(1, 3, -1, -3, 5, 3, 6, 7);
        int window = 3;
        List<Integer> actual = maxOfAllSubArrays(numbers, window);
        List<Integer> expected = List.of(3, 3, 5, 5, 6, 7);

        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
