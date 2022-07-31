package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class LargestValuesFromLabels {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            Source          :: {}
            Target          :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit);

    public void execute() {
        int[] values;
        int[] labels;
        int numWanted;
        int useLimit;
        Integer actual;
        Integer expected;

        expected = 9;
        values = new int[]{5, 4, 3, 2, 1};
        labels = new int[]{1, 1, 2, 2, 3};
        numWanted = 3;
        useLimit = 1;
        actual = largestValsFromLabels(values, labels, numWanted, useLimit);
        log.debug(LOG_STR, getClass().getSimpleName(), values, labels, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
