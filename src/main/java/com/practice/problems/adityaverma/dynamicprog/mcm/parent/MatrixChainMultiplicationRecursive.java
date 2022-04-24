package com.practice.problems.adityaverma.dynamicprog.mcm.parent;

import com.google.common.primitives.Ints;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Input: p[] = {40, 20, 30, 10, 30}
 * Output: 26000
 * There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 * Let the input 4 matrices be A, B, C and D.  The minimum number of
 * multiplications are obtained by putting parenthesis in following way
 * (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 * <p>
 * Input: p[] = {10, 20, 30, 40, 30}
 * Output: 30000
 * There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 * Let the input 4 matrices be A, B, C and D.  The minimum number of
 * multiplications are obtained by putting parenthesis in following way
 * ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 * <p>
 * Input: p[] = {10, 20, 30}
 * Output: 6000
 * There are only two matrices of dimensions 10x20 and 20x30. So there
 * is only one way to multiply the matrices, cost of which is 10*20*30
 **/

@Log4j2
public class MatrixChainMultiplicationRecursive {

    public static void main(String[] args) {
        print(List.of(10, 20, 30), minimumCost -> assertEquals(6000, minimumCost));
        print(List.of(40, 20, 30, 10, 30), minimumCost -> assertEquals(26000, minimumCost));
    }

    private static void print(List<Integer> input, Consumer<Integer> expected) {
        log.info("Input:: {}\t ", input);
        int minimumCost = matrixChainMultiplication(Ints.toArray(input), 1, input.size() - 1);
        log.info("Output:: Minimum cost is `{}`", minimumCost);
        expected.accept(minimumCost);
    }

    public static int matrixChainMultiplication(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int minPartitions = Integer.MAX_VALUE;

        for (int k = low; k <= high - 1; k++) {
            int leftPartitions = matrixChainMultiplication(arr, low, k);
            int rightPartitions = matrixChainMultiplication(arr, k + 1, high);
            //log.debug("arr[{}] * arr[{}] * arr[{}] ==> {} * {} * {}", low - 1, k, high, arr[low - 1], arr[k], arr[high]);
            int partitionValue = arr[low - 1] * arr[k] * arr[high];

            int totalPartitions = leftPartitions + partitionValue + rightPartitions;
            //log.debug("leftPartitions + rightPartitions + partitionValue => {} + {} + {} = {}", leftPartitions, rightPartitions, partitionValue, totalPartitions);
            minPartitions = Math.min(minPartitions, totalPartitions);
        }

        return minPartitions;
    }
}
