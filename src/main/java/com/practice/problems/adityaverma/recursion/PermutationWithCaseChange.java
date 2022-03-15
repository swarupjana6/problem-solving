package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.*;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 *
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 *
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 *
 * Constraints:
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and digits.
 * **/

@Log4j2
public class PermutationWithCaseChange {

    // Choices :: Convert character to uppercase or keep it as is
    public static void main(String[] args) {
        String input = "abc";
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
        output1 += input.toCharArray()[0];
        output2 += convertCase(input.toCharArray()[0]);

        // STEP 3 :: Reduce the input for next step
        input = input.substring(1);

        // STEP 4 :: Call next step branches
        solve(input, output1, outputs);
        solve(input, output2, outputs);
    }

    private static char convertCase(Character input) {
        return (isUpperCase(input) ? toLowerCase(input) : toUpperCase(input));
    }
}
