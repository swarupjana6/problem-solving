package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given an n x n matrix and a number x,
 * find the position of x in the matrix if it is present in it.
 * Otherwise, print “Not Found”.
 * In the given matrix, every row and column is sorted in increasing order.
 * The designed algorithm should have linear time complexity.
 * <p>
 * Input: mat[4][4] = { {10, 20, 30, 40},
 * {15, 25, 35, 45},
 * {27, 29, 37, 48},
 * {32, 33, 39, 50}};
 * x = 29
 * Output: Found at (2, 1)
 * Explanation: Element at (2,1) is 29
 * <p>
 * Input : mat[4][4] = { {10, 20, 30, 40},
 * {15, 25, 35, 45},
 * {27, 29, 37, 48},
 * {32, 33, 39, 50}};
 * x = 100
 * Output : Element not found
 * Explanation: Element 100 is not found
 **/

@Log4j2
public class SearchInRowWiseAndColumnWiseSortedArray {

    public static void main(String[] args) {
        int[][] sortedMatrix =
                {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}};
        int search = 29;

        log.info("Input: {} | Search for: {}", sortedMatrix, search);
        log.info("Output: Index of '{}' is {} ", search, binarySearch(sortedMatrix, search));
    }

    public static List<Integer> binarySearch(int[][] matrix, int search) {
        int length = matrix[0].length;  //m
        int breadth = matrix.length;    //n

        int start = 0;
        int end = length - 1;

        while (start >= 0 && start < breadth && end >= 0 && end < length) {

            if (matrix[start][end] == search) return List.of(start, end);
            else if (matrix[start][end] > search) end--;
            else if (matrix[start][end] < search) start++;
        }

        return List.of(-1);
    }
}
