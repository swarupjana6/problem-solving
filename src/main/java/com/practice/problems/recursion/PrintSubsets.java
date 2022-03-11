package com.practice.problems.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PrintSubsets {

    public static void main(String[] args) {
        String input = "ab";
        List<String> outputList = new ArrayList<>();
        solve(input, "", outputList);
        log.info("\nInput => {} \nOutput => {} ", input, String.join(" | ", outputList));
    }

    private static void solve(String input, String output, List<String> outputList) {
        if (input.length() == 0) {
            outputList.add(output);
            return;
        }
        String output1 = output;
        String output2 = output;

        output2 += input.toCharArray()[0];
        input = input.substring(1);

        solve(input, output1, outputList);
        solve(input, output2, outputList);
    }
}
