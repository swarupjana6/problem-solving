package com.practice.problems.adityavermapractice.slidingwindow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an array and a positive integer k,
 * find the first negative integer for each window(contiguous subarray) of size k.
 * If a window does not contain a negative integer, then print 0 for that window.
 * <p>
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 * <p>
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15 0
 **/


@Log4j2
public abstract class FirstNegativeNumberInEveryWindow {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract List<Integer> firstNegativeNumberInEveryWindow(List<Integer> inputList, Integer window);

    public void execute() {
        List<Integer> input = List.of(12, -1, -7, 8, -15, 30, 16, 28);
        Integer window = 3;
        List<Integer> actual = firstNegativeNumberInEveryWindow(input, window);
        List<Integer> expected = List.of(-1, -1, -7, -15, -15, 0);

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
