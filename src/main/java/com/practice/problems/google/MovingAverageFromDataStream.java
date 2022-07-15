package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class MovingAverageFromDataStream {

    protected abstract void init(int maxSize);

    final BiConsumer<Double, Double> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Double next(int val);

    public void execute() {
        Integer[] nums;
        int size;
        Double actual = 0d;
        Double expected = 0d;

        nums = new Integer[]{3, 1, 10, 3, 5};
        size = 3;
        init(size);
        for(int num : nums) actual = next(num);
        expected = 6d;
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
