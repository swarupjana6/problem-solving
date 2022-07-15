package com.practice.problems.google.impl.tap;

import com.practice.problems.google.NumberOfIslands;

public class NumberOfIslandsTap extends NumberOfIslands {
    @Override
    protected Integer noOfIslands(Integer[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Integer noOfIslands = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1) noOfIslands += checkIsland(grid, i, j);

        return noOfIslands;
    }

    private Integer checkIsland(Integer[][] grid, int i, int j) {
        // BASE CONDITION
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return 0;

        // HYPOTHESIS
        grid[i][j] = 0;
        checkIsland(grid, i + 1, j);
        checkIsland(grid, i - 1, j);
        checkIsland(grid, i, j + 1);
        checkIsland(grid, i, j - 1);

        // INDUCTION
        return 1;
    }
}
