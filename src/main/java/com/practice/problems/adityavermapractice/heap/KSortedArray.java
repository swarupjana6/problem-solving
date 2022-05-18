package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given a k–sorted array that is almost sorted
 * such that each of the n elements may be misplaced by no more than k positions from the correct sorted order.
 * Input: arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9] k = 2
 * Output:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 **/
@Log4j2
public abstract class KSortedArray {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<Integer> kSortedArray(List<Integer> inputList, int k);

    public void execute() {
        List<Integer> input = List.of(6, 5, 3, 2, 8, 10, 9);
        List<Integer> actual = kSortedArray(input, 3);
        List<Integer> expected = List.of(8, 9, 10);

        Collections.sort(actual);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
