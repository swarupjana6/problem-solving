package com.practice.problems.adityavermapractice.dynamicprog.mcm.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.mcm.EvaluateExpressionToTrueParenthesization;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrueParenthesizationTap extends EvaluateExpressionToTrueParenthesization {

    static Map<String, Integer> cached = new HashMap<>();

    @Override
    protected Integer memoizedMCM(char[] arr) {
        return memoizedMCM(arr, 0, arr.length - 1, true);
    }

    private int memoizedMCM(char[] arr, int low, int high, boolean isTrue) {
        if (low > high) return 0;
        String key = low + "-" + high + "-" + isTrue;
        if (cached.containsKey(key)) return cached.get(key);

        if (low == high) {
            if (isTrue) return (arr[low] == 'T') ? 1 : 0;
            else return (arr[low] == 'F') ? 1 : 0;
        }

        int minParts = 0;
        for (int operator = low + 1; operator < high; operator = operator + 2) {
            int leftTrue = recursiveMCM(arr, low, operator - 1, true);
            int leftFalse = recursiveMCM(arr, low, operator - 1, false);

            int rightTrue = recursiveMCM(arr, operator + 1, high, true);
            int rightFalse = recursiveMCM(arr, operator + 1, high, false);

            switch (arr[operator]) {
                case '&' -> {
                    /*
                     T & T = True
                     ------------
                     T & F = False
                     F & T = False
                     F & F = False
                     */
                    if (isTrue) minParts += (leftTrue * rightTrue);
                    else minParts += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }
                case '|' -> {
                    /*
                     T | T = True
                     T | F = True
                     F | T = True
                     -------------
                     F | F = False
                     */
                    if (isTrue) minParts += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    else minParts += (leftFalse * rightFalse);
                }
                case '^' -> {
                    /*
                     T | F = True
                     F | T = True
                     -------------
                     T | T = False
                     F | F = False
                     */
                    if (isTrue) minParts += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    else minParts += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }
        }

        cached.put(key, minParts);
        return minParts;
    }

    @Override
    protected Integer recursiveMCM(char[] arr) {
        int partitions = recursiveMCM(arr, 0, arr.length - 1, true);
        return partitions;
    }

    private int recursiveMCM(char[] arr, int low, int high, boolean isTrue) {
        if (low > high) return 0;
        if (low == high) {
            if (isTrue) return arr[low] == 'T' ? 1 : 0;
            else return arr[low] == 'F' ? 1 : 0;
        }

        int minParts = 0;
        for (int operator = low + 1; operator < high; operator = operator + 2) {
            int leftTrue = recursiveMCM(arr, low, operator - 1, true);
            int leftFalse = recursiveMCM(arr, low, operator - 1, false);

            int rightTrue = recursiveMCM(arr, operator + 1, high, true);
            int rightFalse = recursiveMCM(arr, operator + 1, high, false);

            switch (arr[operator]) {
                case '&' -> {
                    /*
                     T & T = True
                     ------------
                     T & F = False
                     F & T = False
                     F & F = False
                     */
                    if (isTrue) minParts += (leftTrue * rightTrue);
                    else minParts += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }
                case '|' -> {
                    /*
                     T | T = True
                     T | F = True
                     F | T = True
                     -------------
                     F | F = False
                     */
                    if (isTrue) minParts += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    else minParts += (leftFalse * rightFalse);
                }
                case '^' -> {
                    /*
                     T | F = True
                     F | T = True
                     -------------
                     T | T = False
                     F | F = False
                     */
                    if (isTrue) minParts += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    else minParts += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }
        }

        return minParts;
    }
}
