package com.practice.problems.google.impl.tap;

import com.practice.problems.google.BattleshipsInABoard;

public class BattleshipsInABoardTap extends BattleshipsInABoard {
    @Override
    protected Integer countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;

        Integer noOfBattleShips = 0;

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                //noOfBattleShips += solution1(board, i, j);

                //Solution 2
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                noOfBattleShips++;
            }

        return noOfBattleShips;
    }

    private int solution2(char[][] board, int i, int j) {

        return 0;
    }

    private int solution1(char[][] board, int i, int j) {
        if (board[i][j] == 'X') {
            sink(board, i, j);
            return 1;
        }
        return 0;
    }

    private void sink(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != 'X') return;

        board[i][j] = '.';
        sink(board, i + 1, j);
        sink(board, i - 1, j);
        sink(board, i, j + 1);
        sink(board, i, j - 1);
    }
}
