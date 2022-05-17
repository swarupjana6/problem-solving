package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class RainWaterTrapping {

    final BiConsumer<Integer, Integer> IS_ACTUAL_INTEGER_VALID = Assertions::assertEquals;

    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract Integer rainWaterTrapping(List<Integer> buildings);

    public void execute() {
        List<Integer> input = List.of(3, 0, 0, 1, 0, 4);
        Integer actual = rainWaterTrapping(input);
        Integer expected = 11;

        log.debug(LOG_STR, input, actual, expected);
        IS_ACTUAL_INTEGER_VALID.accept(actual, expected);
    }
}
