package com.practice.problems.adityavermapractice.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class PrintLongestCommonSubsequence {

    final BiConsumer<String, String> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            first               :: {}
            second              :: {}
            O/P actual Recursive:: {}
            O/P actual Memoized :: {}
            O/P actual TopDown  :: {}
            O/P expected        :: {}
            """;

    public abstract String lcsRecursive(String first, String second);

    public abstract String lcsMemoized(String first, String second);

    public abstract String lcsTopdown(String first, String second);

    public void execute() {
        String first;
        String second;
        String actualR;
        String actualM;
        String actualTD;
        String expected;

        first = "abcdgh";
        second = "abedfhr";
        expected = "abdh";
        actualR = lcsRecursive(first, second);
        actualM = lcsMemoized(first, second);
        actualTD = lcsTopdown(first, second);
        log.debug(LOG_STR, getClass().getSimpleName(), first, second, actualR, actualM, actualTD, expected);
        //IS_EXPECTED.accept(expected, actualR);
        //IS_EXPECTED.accept(expected, actualM);
        IS_EXPECTED.accept(expected, actualTD);
    }
}
