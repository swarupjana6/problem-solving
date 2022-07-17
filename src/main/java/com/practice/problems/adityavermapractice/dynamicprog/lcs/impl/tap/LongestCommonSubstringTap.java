package com.practice.problems.adityavermapractice.dynamicprog.lcs.impl.tap;


import com.practice.problems.adityavermapractice.dynamicprog.lcs.LongestCommonSubstring;

public class LongestCommonSubstringTap extends LongestCommonSubstring {

    private String first;

    private String second;

    public int[][] results;

    @Override
    public Integer lcsRecursive(String first, String second) {
        this.first = first;
        this.second = second;
        return recursive(first.length() - 1, second.length() - 1, 0);
    }

    @Override
    public Integer lcsMemoized(String first, String second) {
        this.first = first;
        this.second = second;
        this.results = new int[first.length() + 1][second.length() + 1];

        for (int fst = 0; fst <= first.length(); fst++)
            for (int sec = 0; sec <= second.length(); sec++) results[fst][sec] = -1;

        return memoized(first.length() - 1, second.length() - 1, 0);
    }

    @Override
    public Integer lcsTopdown(String first, String second) {
        this.first = first;
        this.second = second;
        return topDown();
    }

    private Integer recursive(int firstIndex, int secondIndex, int count) {
        //BASE CONDITION
        if (firstIndex == -1 || secondIndex == -1) return count;

        //CHOICE DIAGRAM && SMALLER INPUT
        if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
            count = recursive(firstIndex - 1, secondIndex - 1, count + 1);
        } else {
            int firstCount = recursive(firstIndex - 1, secondIndex, 0);
            int secondCount = recursive(firstIndex, secondIndex - 1, 0);
            count = Math.max(count, Math.max(firstCount, secondCount));
        }

        return count;
    }

    private Integer memoized(int firstIndex, int secondIndex, int count) {
        //BASE CONDITION
        if (firstIndex == -1 || secondIndex == -1) return 0;

        if (results[firstIndex][secondIndex] != -1) return results[firstIndex][secondIndex];

        //CHOICE DIAGRAM && SMALLER INPUT
        if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
            return results[firstIndex][secondIndex] = memoized(firstIndex - 1, secondIndex - 1, count + 1);
        } else {
            int firstCount = recursive(firstIndex - 1, secondIndex, 0);
            int secondCount = recursive(firstIndex, secondIndex - 1, 0);
            count = Math.max(count, Math.max(firstCount, secondCount));
            return results[firstIndex][secondIndex] = count;
        }
    }

    private Integer topDown() {
        int max = 0;
        int firstIndex = first.length() + 1;
        int secondIndex = second.length() + 1;

        int[][] results = new int[firstIndex][secondIndex];

        for (int fst = 0; fst < firstIndex; fst++) results[fst][0] = 0;
        for (int sec = 0; sec < secondIndex; sec++) results[0][sec] = 0;

        for (int fst = 1; fst < firstIndex; fst++) {
            for (int sec = 1; sec < secondIndex; sec++) {
                char fstChar = first.charAt(fst - 1);
                char secChar = second.charAt(sec - 1);

                if (fstChar == secChar) {
                    results[fst][sec] = 1 + results[fst - 1][sec - 1];
                    max = Math.max(max, results[fst][sec]);
                } else results[fst][sec] = 0;
            }
        }

        return max;
    }
}
