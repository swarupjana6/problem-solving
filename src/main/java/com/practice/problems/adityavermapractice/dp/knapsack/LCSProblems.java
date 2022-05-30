package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.HashMap;
import java.util.Map;

public class LCSProblems {

    public static int exeLongestCommonSubsequenceRecursive(String first, String second) {
        return LongestCommonSubsequence.recursive(first, second, first.length(), second.length());
    }

    public static int exeLongestCommonSubsequenceTopDown(String first, String second) {
        return LongestCommonSubsequence.topDown(first, second);
    }

    public static int exeLongestCommonSubsequenceMemoized(String first, String second) {
        return LongestCommonSubsequence.memoized(first, second, first.length(), second.length());
    }

    public static int exeLongestCommonSubStringRecursive(String first, String second) {
        return LongestCommonSubstring.recursive(first, second, first.length(), second.length());
    }

    public static int exeLongestCommonSubStringTopDown(String first, String second) {
        return LongestCommonSubstring.topDown(first, second);
    }

    public static int exeLongestCommonSubStringMemoized(String first, String second) {
        return LongestCommonSubstring.memoized(first, second, first.length(), second.length());
    }

    public static String exePrintLongestCommonSubsequenceTopDown(String first, String second) {
        return PrintLongestCommonSubsequence.topDown(first, second);
    }

    public static String exePrintShortestCommonSuperSequenceTopDown(String first, String second) {
        return PrintShortestCommonSuperSequence.topDown(first, second);
    }
}

class LongestCommonSubsequence {

    public static int recursive(String first, String second, int firstIndex, int secondIndex) {
        if (firstIndex == 0 || secondIndex == 0) return 0;

        if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
            return 1 + recursive(first, second, firstIndex - 1, secondIndex - 1);
        } else {
            int smallerFirst = recursive(first, second, firstIndex - 1, secondIndex);
            int smallerSecond = recursive(first, second, firstIndex, secondIndex - 1);
            return Math.max(smallerFirst, smallerSecond);
        }
    }

    public static int topDown(String first, String second) {
        if (first.length() == 0 || second.length() == 0) return 0;

        int firstLen = first.length();
        int secondLen = second.length();
        int[][] results = getResults(first, second, firstLen, secondLen);

        return results[firstLen][secondLen];
    }

    public static int[][] getResults(String first, String second, int firstLen, int secondLen) {
        int[][] results = new int[firstLen + 1][secondLen + 1];

        for (int firstIndex = 0; firstIndex <= firstLen; firstIndex++) results[firstIndex][0] = 0;
        for (int secondIndex = 0; secondIndex <= secondLen; secondIndex++) results[0][secondIndex] = 0;

        for (int firstIndex = 1; firstIndex <= firstLen; firstIndex++) {
            for (int secondIndex = 1; secondIndex <= secondLen; secondIndex++) {
                if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
                    results[firstIndex][secondIndex] = 1 + results[firstIndex - 1][secondIndex - 1];
                } else {
                    int firstReducedResult = results[firstIndex - 1][secondIndex];
                    int secondReducedResult = results[firstIndex][secondIndex - 1];
                    results[firstIndex][secondIndex] = Math.max(firstReducedResult, secondReducedResult);
                }
            }
        }
        return results;
    }

    static Map<String, Integer> cached = new HashMap<>();

    public static int memoized(String first, String second, int firstIndex, int secondIndex) {
        if (firstIndex == 0 || secondIndex == 0) return 0;
        String key = firstIndex + "-" + secondIndex;
        if (cached.containsKey(key)) return cached.get(key);

        if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
            cached.put(key, 1 + memoized(first, second, firstIndex - 1, secondIndex - 1));
        } else {
            int smallerFirst = memoized(first, second, firstIndex - 1, secondIndex);
            int smallerSecond = memoized(first, second, firstIndex, secondIndex - 1);
            cached.put(key, Math.max(smallerFirst, smallerSecond));
        }
        return cached.get(key);
    }
}

class LongestCommonSubstring {

    public static int recursive(String first, String second, int firstIndex, int secondIndex) {
        if (firstIndex == 0 || secondIndex == 0) return 0;

        if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
            return 1 + recursive(first, second, firstIndex - 1, secondIndex - 1);
        } else {
            return 0;
        }
    }

    public static int topDown(String first, String second) {
        if (first.length() == 0 || second.length() == 0) return 0;

        int firstLen = first.length();
        int secondLen = second.length();
        int[][] results = getResults(first, second, firstLen, secondLen);

        return results[firstLen][secondLen];
    }

    public static int[][] getResults(String first, String second, int firstLen, int secondLen) {
        int[][] results = new int[firstLen + 1][secondLen + 1];

        for (int firstIndex = 0; firstIndex <= firstLen; firstIndex++) results[firstIndex][0] = 0;
        for (int secondIndex = 0; secondIndex <= secondLen; secondIndex++) results[0][secondIndex] = 0;

        for (int firstIndex = 1; firstIndex <= firstLen; firstIndex++) {
            for (int secondIndex = 1; secondIndex <= secondLen; secondIndex++) {
                if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
                    results[firstIndex][secondIndex] = 1 + results[firstIndex - 1][secondIndex - 1];
                } else {
                    results[firstIndex][secondIndex] = 0;
                }
            }
        }
        return results;
    }

    static Map<String, Integer> cached = new HashMap<>();

    public static int memoized(String first, String second, int firstIndex, int secondIndex) {
        if (firstIndex == 0 || secondIndex == 0) return 0;
        String key = firstIndex + "-" + secondIndex;
        if (cached.containsKey(key)) return cached.get(key);

        int result = 0;
        if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1))
            result = 1 + recursive(first, second, firstIndex - 1, secondIndex - 1);
        else
            result = 0;

        cached.put(key, result);
        return result;
    }
}

class PrintLongestCommonSubsequence {

    public static String topDown(String first, String second) {
        int[][] results = LongestCommonSubsequence.getResults(first, second, first.length(), second.length());

        StringBuilder output = new StringBuilder();
        int firstLen = first.length();
        int secondLen = second.length();

        while (firstLen > 0 && secondLen > 0) {
            if (first.charAt(firstLen - 1) == second.charAt(secondLen - 1)) {
                firstLen--;
                secondLen--;
                output.append(first.charAt(firstLen));
            } else {
                if (results[firstLen][secondLen] == results[firstLen - 1][secondLen]) firstLen -= 1;
                else secondLen -= 1;
            }
        }

        return output.reverse().toString();
    }
}

class PrintShortestCommonSuperSequence {

    public static String topDown(String first, String second) {
        int[][] results = LongestCommonSubsequence.getResults(first, second, first.length(), second.length());

        StringBuilder output = new StringBuilder();
        int firstLen = first.length();
        int secondLen = second.length();

        while (firstLen > 0 && secondLen > 0) {
            if (first.charAt(firstLen - 1) == second.charAt(secondLen - 1)) {
                output.append(first.charAt(firstLen - 1));
                firstLen--;
                secondLen--;
            } else {
                if (results[firstLen][secondLen - 1] > results[firstLen - 1][secondLen]) {
                    firstLen--;
                } else {
                    secondLen--;
                }
            }
        }

        System.out.println(output.reverse().toString());
        /*while (firstLen != 0) output.append(first.charAt(--firstLen));
        while (secondLen != 0) output.append(first.charAt(--secondLen));*/

        return output.reverse().toString();
    }
}