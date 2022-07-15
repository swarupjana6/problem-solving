package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class UniqueEmailAddresses {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract int countUniqueEmailAddresses(String[] emails);

    public void execute() {
        String[] emails;
        Integer actual;
        Integer expected;

        emails = new String[]{"test.email+alex@leetcode.com"
                , "test.e.mail+bob.cathy@leetcode.com"
                , "testemail+david@lee.tcode.com"};
        actual = countUniqueEmailAddresses(emails);
        expected = 2;
        log.debug(LOG_STR, getClass().getSimpleName(), emails, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        emails = new String[]{"a@leetcode.com"
                , "b@leetcode.com"
                , "c@leetcode.com"};
        actual = countUniqueEmailAddresses(emails);
        expected = 3;
        log.debug(LOG_STR, getClass().getSimpleName(), emails, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        emails = new String[]{"test.email+alex@leetcode.com"
                , "test.email@leetcode.com"};
        actual = countUniqueEmailAddresses(emails);
        expected = 1;
        log.debug(LOG_STR, getClass().getSimpleName(), emails, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        emails = new String[]{"linqmafia@leet+code.com"
                , "linqmafia@code.com"};
        actual = countUniqueEmailAddresses(emails);
        expected = 2;
        log.debug(LOG_STR, getClass().getSimpleName(), emails, actual, expected);
        IS_EXPECTED.accept(expected, actual);

    }
}
