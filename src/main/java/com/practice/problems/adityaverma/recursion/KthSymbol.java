package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
 * Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
 * Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 * <p>
 * Input: n = 1, k = 1
 * Output: 0
 * Explanation: row 1: 0
 * <p>
 * Input: n = 2, k = 1
 * Output: 0
 * Explanation:
 * row 1: 0
 * row 2: 01
 * <p>
 * Input: n = 2, k = 2
 * Output: 1
 * Explanation:
 * row 1: 0
 * row 2: 01
 **/
@Log4j2
public class KthSymbol {

    public static void main(String[] args) {
        assertEquals(1, solve(2, 2));
    }

    private static int solve(int n, int k) {
        //BASE CONDITION
        if (n == 1 && k == 1) return 0;

        //INDUCTION && HYPOTHESIS
        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid) return solve(n - 1, k);
        else return -1 * (solve(n - 1, k - mid) - 1);
    }
}
