package com.practice.problems.adityavermapractice.dynamicprog.lcs.impl.tap;


import com.practice.problems.adityavermapractice.dynamicprog.lcs.LongestCommonSubsequence;

public class LongestCommonSubsequenceTap extends LongestCommonSubsequence {

    private String first;

    private String second;

    public int[][] results;

    @Override
    public Integer lcsRecursive(String first, String second) {
        this.first = first;
        this.second = second;
        return recursive(first.length() - 1, second.length() - 1);
    }

    @Override
    public Integer lcsMemoized(String first, String second) {
        this.first = first;
        this.second = second;
        this.results = new int[first.length() + 1][second.length() + 1];

        for (int fst = 0; fst <= first.length(); fst++)
            for (int sec = 0; sec <= second.length(); sec++) results[fst][sec] = -1;

        return memoized(first.length() - 1, second.length() - 1);
    }

    @Override
    public Integer lcsTopdown(String first, String second) {
        this.first = first;
        this.second = second;
        return topDown();
    }

    private Integer recursive(int firstIndex, int secondIndex) {
        //BASE CONDITION
        if (firstIndex == -1 || secondIndex == -1) return 0;

        //CHOICE DIAGRAM && SMALLER INPUT
        if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
            return 1 + recursive(firstIndex - 1, secondIndex - 1);
        } else {
            int firstCount = recursive(firstIndex - 1, secondIndex);
            int secondCount = recursive(firstIndex, secondIndex - 1);
            return Math.max(firstCount, secondCount);
        }
    }

    private Integer memoized(int firstIndex, int secondIndex) {
        //BASE CONDITION
        if (firstIndex == -1 || secondIndex == -1) return 0;

        if (results[firstIndex][secondIndex] != -1) return results[firstIndex][secondIndex];

        //CHOICE DIAGRAM && SMALLER INPUT
        if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
            return results[firstIndex][secondIndex] = 1 + recursive(firstIndex - 1, secondIndex - 1);
        } else {
            results[firstIndex - 1][secondIndex] = recursive(firstIndex - 1, secondIndex);
            results[firstIndex][secondIndex - 1] = recursive(firstIndex, secondIndex - 1);
            int result = Math.max(results[firstIndex - 1][secondIndex], results[firstIndex][secondIndex - 1]);
            return results[firstIndex][secondIndex] = result;
        }
    }

    private Integer topDown() {
        int firstIndex = first.length() + 1;
        int secondIndex = second.length() + 1;

        int[][] results = new int[firstIndex][secondIndex];

        for (int fst = 0; fst < firstIndex; fst++) results[fst][0] = 0;
        for (int sec = 0; sec < secondIndex; sec++) results[0][sec] = 0;

        for (int fst = 1; fst < firstIndex; fst++) {
            for (int sec = 1; sec < secondIndex; sec++) {
                char fstChar = first.charAt(fst - 1);
                char secChar = second.charAt(sec - 1);

                if (fstChar == secChar) results[fst][sec] = 1 + results[fst - 1][sec - 1];
                else results[fst][sec] = Math.max(results[fst - 1][sec], results[fst][sec - 1]);
            }
        }

        return results[firstIndex - 1][secondIndex - 1];
    }
}
