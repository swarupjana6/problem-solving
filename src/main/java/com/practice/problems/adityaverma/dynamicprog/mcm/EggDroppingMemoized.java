package com.practice.problems.adityaverma.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class EggDroppingMemoized {

    static Map<String, Integer> cached = new HashMap<>();

    public static void main(String[] args) {
        print(6, 3, expressionValue -> assertTrue(expressionValue == 2));
        print(2, 6, expressionValue -> assertTrue(expressionValue == 3));
        print(3, 14, expressionValue -> assertTrue(expressionValue == 4));
    }

    private static void print(int eggs, int floors, Consumer<Integer> expected) {
        log.info("Input:: Eggs: {} || Floors: {} \t ", eggs, floors);
        int attempts = solve(eggs, floors);
        log.info("Output:: No of attempts `{}` ", attempts);
        expected.accept(attempts);
    }

    public static int solve(int eggs, int floors) {
        if (floors == 1 || floors == 0) return floors;
        if (eggs == 1) return floors;

        String key = eggs + "-" + floors;
        if (cached.containsKey(key)) return cached.get(key);

        int minimum = Integer.MAX_VALUE;
        for (int partition = 1; partition < floors; partition++) {
            int attempts = 1 + Math.max(solve(eggs - 1, partition - 1), solve(eggs, floors - partition));
            minimum = Math.min(minimum, attempts);
        }

        cached.put(key, minimum);
        return minimum;
    }
}
