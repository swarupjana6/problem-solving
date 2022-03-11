package com.practice.problems.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;

@Log4j2
public class GenerateAllBalancedParentheses {

    public static void main(String[] args) {
        Set<String> outputs = new HashSet<>();
        Integer noOfBrackets = 3;
        String output = "";
        solve(noOfBrackets, noOfBrackets, output, outputs);
        log.info("\nInput\t=> {} \nOutput\t=> {} ", noOfBrackets, String.join(" | ", outputs));
    }

    private static void solve(int openCount, int closeCount, String output, Set<String> outputs) {
        if (openCount == 0 && closeCount == 0) {
            outputs.add(output);
            return;
        }

        if (openCount != 0) {
            String output1 = output;
            output1 += "(";
            solve(openCount - 1, closeCount, output1, outputs);
        }

        if (closeCount > openCount) {
            String output2 = output;
            output2 += ")";
            solve(openCount, closeCount - 1, output2, outputs);
        }
    }
}
