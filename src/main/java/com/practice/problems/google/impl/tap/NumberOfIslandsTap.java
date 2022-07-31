package com.practice.problems.google.impl.tap;

import com.practice.problems.google.NumberOfIslands;

public class NumberOfIslandsTap extends NumberOfIslands {

    private Integer[][] grid;

    @Override
    protected Integer noOfIslands(Integer[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.grid = grid;

        Integer noOfIslands = 0;
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (grid[row][col] == 1) noOfIslands += checkIsland(row, col);

        return noOfIslands;
    }

    private Integer checkIsland(int row, int col) {
        // BASE CONDITION
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) return 0;

        // HYPOTHESIS
        grid[row][col] = 0;
        checkIsland(row + 1, col);
        checkIsland(row - 1, col);
        checkIsland(row, col + 1);
        checkIsland(row, col - 1);

        // INDUCTION
        return 1;
    }
}
