package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an 1D integer array A of size N you have to find and return the B largest elements of the array A.
 * NOTE: Return the largest B elements in any order you like.
 * <p>
 * Input 1: A = [11, 3, 4] B = 2
 * Output 1: [11, 4]
 * <p>
 * Input 2: A = [11, 3, 4, 6] B = 3
 * Output 2: [4, 6, 11]
 **/
@Log4j2
public abstract class KLargestElement {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<Integer> kLargest(List<Integer> inputList, int k);

    public void execute() {
        List<Integer> input = List.of(7, 10, 4, 3, 20, 15);
        List<Integer> actual = kLargest(input, 3);
        List<Integer> expected = List.of(10, 15, 20);

        Collections.sort(actual);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
