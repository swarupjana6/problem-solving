package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class LetterCombinations {

    final BiConsumer<List<String>, List<String>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<String> letterCombinations(String digits);

    public void execute() {
        String digits;
        List<String> actual;
        List<String> expected;

        digits = "";
        expected = List.of();
        actual = letterCombinations(digits);
        log.debug(LOG_STR, getClass().getSimpleName(), digits, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        digits = "23";
        expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        actual = letterCombinations(digits);
        log.debug(LOG_STR, getClass().getSimpleName(), digits, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        digits = "2";
        expected = List.of("a", "b", "c");
        actual = letterCombinations(digits);
        log.debug(LOG_STR, getClass().getSimpleName(), digits, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
