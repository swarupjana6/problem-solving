package com.practice.problems.adityavermapractice.slidingwindow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class MaximumSumSubArrayOfSizeK {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer maximumSumSubArrayOfSizeK(List<Integer> inputList, Integer window);

    public void execute() {
        List<Integer> input = List.of(2, 5, 1, 8, 2, 5, 1);
        Integer window = 3;
        Integer actual = maximumSumSubArrayOfSizeK(input, window);
        Integer expected = 15;

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
