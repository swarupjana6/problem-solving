package com.practice.problems.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.*;

@Log4j2
public class PermutationWithCaseChangeWithDigits {

    // Choices :: Convert character to uppercase or keep it as is
    public static void main(String[] args) {
        String input = "a1bc";
        Set<String> outputs = new HashSet<>();
        solve(input, "", outputs);
        log.info("\nInput\t=> {} \nOutput\t=> {} ", input, String.join(" | ", outputs));
    }

    private static void solve(String input, String output, Set<String> outputs) {
        // STEP 1 :: Check if Leaf node reached
        if (input.length() == 0) {
            outputs.add(output);
            return;
        }

        // STEP 2 :: Calculate output for this step
        String output1 = output;
        String output2 = output;
        char firstChar = input.toCharArray()[0];
        if(!isDigit(firstChar)) {
            output1 += firstChar;
            output2 += convertCase(firstChar);

            // STEP 3 :: Reduce the input for next step
            input = input.substring(1);

            // STEP 4 :: Call next step branches
            solve(input, output1, outputs);
            solve(input, output2, outputs);
        } else {
            output1 += firstChar;
            // STEP 3 :: Reduce the input for next step
            input = input.substring(1);

            // STEP 4 :: Call next step branches
            solve(input, output1, outputs);
        }
    }

    private static char convertCase(Character input) {
        return (isUpperCase(input) ? toLowerCase(input) : toUpperCase(input));
    }
}
