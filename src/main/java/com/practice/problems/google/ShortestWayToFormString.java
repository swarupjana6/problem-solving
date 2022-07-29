package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ShortestWayToFormString {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            Source          :: {}
            Target          :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer shortestWay(String source, String target);

    public void execute() {
        String source;
        String target;
        Integer actual;
        Integer expected;

        expected = 3;
        source = "abc";
        target = "abcbc";
        actual = shortestWay(source, target);
        log.debug(LOG_STR, getClass().getSimpleName(), source, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
