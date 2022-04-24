package com.practice.problems.adityaverma.dynamicprog.tree.parent;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p><br\>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p><br\>
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p><br\>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p><br\>
 * <img src="resource\tree-1.png" />
 * <p><br\>
 * Input: root = [1,2]
 * Output: 1
 * <p><br\>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 * <p><br\>
 **/

@Log4j2
public class DiameterOfTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(10);
        root.right.right = new TreeNode<>(5);
        print(root, maxHeight -> assertEquals(3, maxHeight));
    }

    private static void print(TreeNode root, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {} ", root);
        Integer result = Integer.MIN_VALUE;
        int maximumDiameter = solve(root, result);
        log.info("Output:: Diameter of tree `{}` ", maximumDiameter);
        expected.accept(maximumDiameter);
    }

    public static int solve(TreeNode root, Integer result) {
        /* BASE condition */
        if (root == null)
            return 0;

        /* HYPOTHESIS */
        int left = solve(root.left, result);
        int right = solve(root.right, result);

        /* INDUCTION */
        int temp = 1 + Math.max(left, right);
        int answer = Math.max(temp, 1 + left + right);
        result = Math.max(result, answer);

        return temp;
    }
}
