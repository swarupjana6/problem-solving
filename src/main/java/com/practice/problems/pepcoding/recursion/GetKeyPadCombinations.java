package com.practice.problems.pepcoding.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetKeyPadCombinations {

    private static String[] keyPad = {"?!", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;"};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        List<String> subsequences = getSubSequences(input);
        System.out.println(subsequences);
    }

    private static List<String> getSubSequences(String input) {
        if (input.length() == 0) return List.of("");

        char firstChar = input.charAt(0);
        List<String> remainingSubsequences = getSubSequences(input.substring(1));
        List<String> finalSubsequences = new ArrayList<>();
        for (String seq : remainingSubsequences) {
            finalSubsequences.add("" + seq);
            finalSubsequences.add(firstChar + seq);
        }
        return finalSubsequences;
    }
}
