package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;


@Log4j2
public class PermutationWithSpaces {

    // Choices :: Include the letter WITH SPACES or WITHOUT SPACES
    public static void main(String[] args) {
        String input = "abc";
        Set<String> outputs = new HashSet<>();
        solve(input.substring(1), input.substring(0, 1), outputs);
        log.info("\nInput\t=> {} \nOutput\t=> {} ", input, String.join(" | ", outputs));
    }

    private static void solve(String input, String output, Set<String> outputs) {
        // Check if Leaf node reached
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
        solve(input, output1, outputs);
        solve(input, output2, outputs);
    }
}
