package com.practice.problems.adityavermapractice.heap;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is
 * the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 **/

@Log4j2
public abstract class KClosestPointToOrigin {
    final BiConsumer<List<List<Integer>>, List<List<Integer>>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<List<Integer>> kClosestPointToOrigin(Integer[][] input, int k);

    public void execute() {
        Integer[][] input = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        List<List<Integer>> actual = kClosestPointToOrigin(input, k);
        List<List<Integer>> expected = List.of(List.of(-2, 2), List.of(0, 1));

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
