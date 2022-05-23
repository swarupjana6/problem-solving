package com.practice.problems.adityavermapractice.recursion.tap;

import java.util.List;
import java.util.Set;

public class SubsetMethodEasyMedium {

    public static void template() {
        // STEP 1 :: Check if Leaf node reached

        // STEP 2 :: Calculate output for this step

        // STEP 3 :: Reduce the input for next step

        // STEP 4 :: Call next step branches
    }

    public static void subset(String input, String output, List<String> outputs) {
        // STEP 1 :: Check INPUT is empty
        if (input.length() == 0) {
            outputs.add("'" + output + "'");
            return;
        }

        // STEP 2 :: Calculate OUTPUT for current step
        String output1 = output;
        String output2 = output;
        output1 += "";
        output2 += input.substring(0, 1);

        // STEP 3 :: Reduce the INPUT for next step
        input = input.substring(1);

        // STEP 4 :: Call next step branches
        subset(input, output1, outputs);
        subset(input, output2, outputs);
    }

    public static void uniqueSubset(String input, String output, Set<String> outputs) {
        // STEP 1 :: Check if Leaf node reached
        if (input.length() == 0) {
            outputs.add("'" + output + "'");
            return;
        }

        // STEP 2 :: Calculate output for this step
        String output1 = output;
        String output2 = output;
        output1 += "";
        output2 += input.substring(0, 1);

        // STEP 3 :: Reduce the input for next step
        input = input.substring(1);

        // STEP 4 :: Call next step branches
        uniqueSubset(input, output1, outputs);
        uniqueSubset(input, output2, outputs);
    }

    public static void permutationWithSpaces(String input, String output, Set<String> outputs) {
        // STEP 1 :: Check if Leaf node reached
        if (input.length() == 0) {
            outputs.add("'" + output + "'");
            return;
        }

        // STEP 2 :: Calculate output for this step
        String output1 = output;
        String output2 = output;
        output1 += " " + input.substring(0, 1);
        output2 += input.substring(0, 1);

        // STEP 3 :: Reduce the input for next step
        input = input.substring(1);

        // STEP 4 :: Call next step branches
        uniqueSubset(input, output1, outputs);
        uniqueSubset(input, output2, outputs);
    }

    public static void letterCaseChange(String input, String output, List<String> outputs) {
        // STEP 1 :: Check if Leaf node reached
        if (input.length() == 0) {
            outputs.add(output);
            return;
        }

        // STEP 2 :: Calculate output for this step
        String output1 = output;
        String output2 = output;
        Character firstChar = input.substring(0, 1).toCharArray()[0];
        output1 += firstChar;
        if (!Character.isDigit(firstChar))
            firstChar = Character.isUpperCase(firstChar) ? Character.toLowerCase(firstChar) : Character.toUpperCase(firstChar);
        output2 += firstChar;

        // STEP 3 :: Reduce the input for next step
        input = input.substring(1);

        // STEP 4 :: Call next step branches
        letterCaseChange(input, output1, outputs);
        letterCaseChange(input, output2, outputs);
    }

    public static void balancedParentheses(String output, List<String> outputs, int open, int close) {
        // STEP 1 :: Check if Leaf node reached
        if (open == 0 && close == 0) {
            outputs.add(output);
            return;
        }

        // STEP 2 :: Calculate output for this step
        String output1 = output;
        String output2 = output;
        if (open != 0) {
            output1 += "(";

            // STEP 3 :: Reduce the input for next step
            // STEP 4 :: Call next step branches
            balancedParentheses(output1, outputs, open - 1, close);
        }
        if (close > open) {
            output2 += ")";

            // STEP 3 :: Reduce the input for next step
            // STEP 4 :: Call next step branches
            balancedParentheses(output2, outputs, open, close - 1);
        }
    }

    public static void noOf1sAnd0s(String output, List<String> outputs, int positions, int ones, int zeros) {
        // STEP 1 :: Check if Leaf node reached
        if (positions == 0) {
            outputs.add(output);
            return;
        }

        // STEP 2 :: Calculate output for this step
        if (zeros < ones) {
            String output1 = output;
            output1 += "0";

            noOf1sAnd0s(output1, outputs, positions - 1, ones, zeros + 1);
        }

        String output2 = output;
        output2 += "1";

        noOf1sAnd0s(output2, outputs, positions - 1, ones + 1, zeros);
    }

}
