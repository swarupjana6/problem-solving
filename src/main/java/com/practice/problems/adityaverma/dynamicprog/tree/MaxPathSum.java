package com.practice.problems.adityaverma.dynamicprog.tree;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
 * in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * <p>
 * <img src="tree-1.png" />
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * <p>
 * <p>
 * <img src="tree-with-minus.png" />
 * <br\>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 **/

@Log4j2
public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(-10);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(7);
        print(root, maxHeight -> assertEquals(42, maxHeight));
    }

    private static void print(TreeNode root, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {} ", root);
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSum(root, result);
        log.info("Output:: MaxPathSum of tree `{}` ", result.get());
        expected.accept(result.get());
    }

    public static int maxPathSum(TreeNode<Integer> root, AtomicInteger result) {
        /* BASE CONDITION */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int leftHeightSum = maxPathSum(root.left, result);
        int rightHeightSum = maxPathSum(root.right, result);

        /* INDUCTION */
        int heightSum = Math.max(leftHeightSum, rightHeightSum) + root.val;
        heightSum = Math.max(heightSum, root.val);

        int diameterSum = leftHeightSum + rightHeightSum + root.val;
        result.set(Math.max(result.get(), Math.max(heightSum, diameterSum)));

        return heightSum;
    }
}
