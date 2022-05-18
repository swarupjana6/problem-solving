package com.practice.problems.adityavermapractice.heap;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an array of integers and two numbers k1 and k2.
 * Find the sum of all elements between given two k1’th and k2’th smallest elements of the array.
 * It may be assumed that (1 <= k1 < k2 <= n) and all elements of array are distinct.
 * <p>
 * Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
 * Output : 26
 * 3rd smallest element is 10. 6th smallest element
 * is 20. Sum of all element between k1 & k2 is
 * 12 + 14 = 26
 * <p>
 * Input : arr[] = {10, 2, 50, 12, 48, 13}, k1 = 2, k2 = 6
 * Output : 73
 **/

@Log4j2
public abstract class SumOfElementBetweenK1K2 {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;

    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer sumOfElementsBetween(List<Integer> numbers, Integer k1, Integer k2);

    public void execute() {
        List<Integer> numbers = List.of(1, 3, 12, 5, 15, 11);
        Integer k1 = 3;
        Integer k2 = 6;
        Integer actual = sumOfElementsBetween(numbers, k1, k2);
        Integer expected = 23;

        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
