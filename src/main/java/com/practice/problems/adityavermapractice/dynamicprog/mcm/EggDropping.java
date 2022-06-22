package com.practice.problems.adityavermapractice.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

/**
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 * <p>
 * You know that there exists a floor f where 0 <= f <= n
 * such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
 * <p>
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
 * If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
 * <p>
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 1, n = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1. If it breaks, we know that f = 0.
 * Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
 * If it does not break, then we know f = 2.
 * Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
 * Example 2:
 * <p>
 * Input: k = 2, n = 6
 * Output: 3
 * Example 3:
 * <p>
 * Input: k = 3, n = 14
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 100
 * 1 <= n <= 104
 **/

@Log4j2
public abstract class EggDropping {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            No of Eggs      :: {}
            No of Floors    :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer eggDroppingMemoized(int eggs, int floors);

    protected abstract Integer eggDroppingRecursive(int eggs, int floors);

    public void execute() {
        Integer eggs;
        Integer floors;
        Integer actualRecursive;
        Integer actualMemoized;
        Integer expected;

        eggs = 6;
        floors = 3;
        expected = 2;
        actualRecursive = eggDroppingRecursive(eggs, floors);
        log.debug(LOG_STR, getClass().getSimpleName(), eggs, floors, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = eggDroppingMemoized(eggs, floors);
        log.debug(LOG_STR, getClass().getSimpleName(), eggs, floors, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);

        eggs = 2;
        floors = 6;
        expected = 3;
        actualRecursive = eggDroppingRecursive(eggs, floors);
        log.debug(LOG_STR, getClass().getSimpleName(), eggs, floors, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = eggDroppingMemoized(eggs, floors);
        log.debug(LOG_STR, getClass().getSimpleName(), eggs, floors, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);

        eggs = 3;
        floors = 14;
        expected = 4;
        actualRecursive = eggDroppingRecursive(eggs, floors);
        log.debug(LOG_STR, getClass().getSimpleName(), eggs, floors, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = eggDroppingMemoized(eggs, floors);
        log.debug(LOG_STR, getClass().getSimpleName(), eggs, floors, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);
    }
}
