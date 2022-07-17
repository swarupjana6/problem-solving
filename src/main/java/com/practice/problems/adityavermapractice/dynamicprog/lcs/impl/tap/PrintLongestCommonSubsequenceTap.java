package com.practice.problems.adityavermapractice.dynamicprog.lcs.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.lcs.PrintLongestCommonSubsequence;

public class PrintLongestCommonSubsequenceTap extends PrintLongestCommonSubsequence {

    private String first;

    private String second;

    @Override
    public String lcsRecursive(String first, String second) {
        this.first = first;
        this.second = second;
        StringBuffer result = new StringBuffer("");
        recursive(first.length() - 1, second.length() - 1, result);
        return result.toString();
    }

    private void recursive(int firstIndex, int secondIndex, StringBuffer result) {

    }

    @Override
    public String lcsMemoized(String first, String second) {
        this.first = first;
        this.second = second;
        return null;
    }

    @Override
    public String lcsTopdown(String first, String second) {
        this.first = first;
        this.second = second;
        int[][] results = topDownResults();
        return getLCSString(results);
    }

    private String getLCSString(int[][] results) {
        StringBuffer lcsString = new StringBuffer("");
        int fst = results.length - 1;
        int sec = results[0].length - 1;

        while (fst > 0 && sec > 0) {
            if (first.charAt(fst - 1) == second.charAt(sec - 1)) {
                lcsString.append(first.charAt(fst - 1));
                fst--;
                sec--;
            } else {
                if (fst - 1 > sec - 1) fst--;
                else sec--;
            }
        }

        return lcsString.reverse().toString();
    }

    private StringBuffer lcsString = new StringBuffer("");

    private int[][] topDownResults() {

        int firstIndex = first.length() + 1;
        int secondIndex = second.length() + 1;

        int[][] results = new int[firstIndex][secondIndex];

        for (int fst = 0; fst < firstIndex; fst++) results[fst][0] = 0;
        for (int sec = 0; sec < secondIndex; sec++) results[0][sec] = 0;

        for (int fst = 1; fst < firstIndex; fst++) {
            for (int sec = 1; sec < secondIndex; sec++) {
                char firstChar = first.charAt(fst - 1);
                char secondChar = second.charAt(sec - 1);

                if (firstChar == secondChar) {
                    results[fst][sec] = 1 + results[fst - 1][sec - 1];
                    lcsString.append(firstChar);
                } else results[fst][sec] = Math.max(results[fst - 1][sec], results[fst][sec - 1]);
            }
        }

        return results;
    }
}
