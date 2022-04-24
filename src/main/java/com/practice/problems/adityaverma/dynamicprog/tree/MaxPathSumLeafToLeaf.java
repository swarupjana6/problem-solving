package com.practice.problems.adityaverma.dynamicprog.tree;

import lombok.extern.log4j.Log4j2;

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
public class MaxPathSumLeafToLeaf {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(10);
        root.right.right = new TreeNode<>(5);
        print(root, maxHeight -> assertEquals(28, maxHeight));
    }

    private static void print(TreeNode root, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {} ", root);
        Integer result = Integer.MIN_VALUE;
        int maximumDiameter = solve(root, result);
        log.info("Output:: Diameter of tree `{}` ", maximumDiameter);
        expected.accept(maximumDiameter);
    }

    public static int solve(TreeNode<Integer> root, Integer result) {
        /* BASE condition */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int left = solve(root.left, result);
        int right = solve(root.right, result);

        /* INDUCTION */
        int temp = Math.max(left, right) + root.value;
        if (root.left == null && root.right == null) temp = Math.max(temp, root.value);
        int answer = Math.max(temp, left + right + root.value);
        result = Math.max(result, answer);

        return temp;
    }
}
