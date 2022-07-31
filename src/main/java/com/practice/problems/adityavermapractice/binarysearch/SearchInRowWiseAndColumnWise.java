package com.practice.problems.adityavermapractice.binarysearch;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class SearchInRowWiseAndColumnWise {

    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            I/P Arr             :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    public abstract List<Integer> findElement(int[][] nums, int search);

    public void execute() {
        int[][] sortedMatrix;
        int search;
        List<Integer> actual;
        List<Integer> expected;

        sortedMatrix = new int[][]
                {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}};
        search = 29;
        expected = List.of(2, 1);
        actual = findElement(sortedMatrix, search);
        log.debug(LOG_STR, getClass().getSimpleName(), sortedMatrix, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
