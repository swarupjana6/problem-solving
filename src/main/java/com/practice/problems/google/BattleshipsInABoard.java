package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class BattleshipsInABoard {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer countBattleships(char[][] heights);

    public void execute() {
        char[][] board;
        Integer actual;
        Integer expected;

        board = new char[][]{
                {'X', '.', '.', 'X'}
                , {'.', '.', '.', 'X'}
                , {'.', '.', '.', 'X'}};
        expected = 2;
        actual = countBattleships(board);
        log.debug(LOG_STR, getClass().getSimpleName(), board, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
