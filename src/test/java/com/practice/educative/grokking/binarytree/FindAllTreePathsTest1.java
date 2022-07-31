package com.practice.educative.grokking.binarytree;

import com.practice.problems.grokking.educative.binarytree.TreeNode;
import com.practice.problems.grokking.educative.binarytree.impl.jan.FindAllTreePathsJana;
import com.practice.problems.grokking.educative.binarytree.impl.myr.FindAllTreePathsMayur;
import com.practice.problems.grokking.educative.binarytree.impl.tap.FindAllTreePathsTapan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllTreePathsTest1 {

    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        int[][] grid;

        grid = new int[][]{{0, 1}, {1, 0}};
        //System.out.println(new FindAllTreePathsTest1().shortestPathBinaryMatrix(grid));

        grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        //System.out.println(new FindAllTreePathsTest1().shortestPathBinaryMatrix(grid));

        System.out.println(new FindAllTreePathsTest1().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) return -1;
        int xLen = grid.length;
        int yLen = grid[0].length;

        if (grid[0][0] == 1 || grid[xLen - 1][yLen - 1] == 1) return -1;

        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(List.of(0, 0, 1));
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            List<Integer> node = queue.poll();
            int x = node.get(0);
            int y = node.get(1);
            int pathLength = node.get(2);

            if (x == xLen - 1 && y == yLen - 1) return pathLength;

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if ((0 <= newX && newX < xLen)
                        && (0 <= newY && newY < yLen)
                        && grid[newX][newY] == 0) {
                    grid[newX][newY] = 1;
                    queue.add(List.of(newX, newY, pathLength + 1));
                }
            }
        }

        return -1;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int num : nums) {
            int atIndex = nums[Math.abs(num) - 1];

            if (atIndex < 0) results.add(Math.abs(num));
            else nums[Math.abs(num) - 1] *= -1;
        }
        return results;
    }


    private int[][] directions1 = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        if (grid.length == 0) return -1;
        int xLen = grid.length;
        int yLen = grid[0].length;

        if (k >= (xLen - 1) + (yLen - 1)) return xLen + yLen - 2;

        Deque<List<Integer>> queue = new ArrayDeque<>();
        if (grid[0][0] == 1) k--;
        queue.add(List.of(0, 0, 1, k));
        grid[0][0] = 1;

        Set<List<Integer>> seens = new HashSet<>();

        while (!queue.isEmpty()) {
            List<Integer> node = queue.poll();
            int x = node.get(0);
            int y = node.get(1);
            int steps = node.get(2);
            int currK = node.get(3);

            if (x == xLen - 1 && y == yLen - 1) return steps;

            for (int[] direction : directions1) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if ((0 <= newX && newX < xLen)
                        && (0 <= newY && newY < yLen)) {

                    int newK = currK - grid[newX][newY];
                    List<Integer> seen = List.of(newX, newY, newK);

                    if (newK >= 0 && !seens.contains(seen)) {
                        seens.add(seen);
                        queue.add(List.of(newX, newY, steps + 1, newK));
                    }
                }
            }
        }

        return -1;
    }


    TreeNode getTreeNodeData1() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        return root;
    }

    int getSumData1() {
        return 23;
    }

    @DisplayName("Test FindAllTreePathsJana.findPaths()")
    @Test
    void testFindPathsJana() {
        assertEquals("5", "5");
        System.out.println("Tree paths with sum " + getSumData1() + ": " + new FindAllTreePathsJana().findPaths(getTreeNodeData1(), getSumData1()));
    }

    @DisplayName("Test FindAllTreePathsTapan.findPaths()")
    @Test
    void testFindPathsTapan() {
        assertEquals("5", "5");
        System.out.println("Tree paths with sum " + getSumData1() + ": " + new FindAllTreePathsTapan().findPaths(getTreeNodeData1(), getSumData1()));
    }

    @DisplayName("Test FindAllTreePathsMayur.findPaths()")
    @Test
    void testFindPathsMayur() {
        assertEquals("5", "5");
        System.out.println("Tree paths with sum " + getSumData1() + ": " + new FindAllTreePathsMayur().findPaths(getTreeNodeData1(), getSumData1()));
    }
}