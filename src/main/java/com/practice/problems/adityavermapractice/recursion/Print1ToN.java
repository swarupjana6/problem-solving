package com.practice.problems.adityavermapractice.recursion;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.io.PrintStream;
import java.util.function.BiConsumer;

@Log4j2
public abstract class Print1ToN {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract void print1ToN(Integer n, PrintStream out);

    public void execute() {
        PrintStream out = System.out;
        Integer n = 3;
        print1ToN(n, out);

        //log.debug(LOG_STR, getClass().getSimpleName(), n, actual, expected);
        //IS_EXPECTED.accept(expected, actual);
    }
}
