package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class FlipAnImage {

    final BiConsumer<int[][], int[][]> IS_EXPECTED = Assertions::assertArrayEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract int[][] flipImage(int[][] image);

    public void execute() {
        int[][] image;
        int[][] actual;
        int[][] expected;

        image = new int[][]{
                {1, 1, 0}
                , {1, 0, 1}
                , {1, 1, 0}};
        expected = new int[][]{
                {1, 0, 0}
                , {0, 1, 0}
                , {1, 1, 1}};
        actual = flipImage(image);
        log.debug(LOG_STR, getClass().getSimpleName(), image, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
