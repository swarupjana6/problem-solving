package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class BalancedBinaryTree {

    public static void main(String[] args) {
        print(getInput1(), isBalanced -> assertEquals(false, isBalanced));
        print(getInput2(), isBalanced -> assertEquals(true, isBalanced));
    }

    private static TreeNode<Integer> getInput2() {
        TreeNode<Integer> root;
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(21);
        root.right = new TreeNode<>(22);
        root.left.left = new TreeNode<>(31);
        root.left.right = new TreeNode<>(32);
        root.right.left = new TreeNode<>(33);
        root.right.right = new TreeNode<>(34);
        return root;
    }

    private static TreeNode<Integer> getInput1() {
        TreeNode<Integer> root = new TreeNode<>(1);

        root.left = new TreeNode<>(21);
        root.left.left = new TreeNode<>(31);
        root.left.left.left = new TreeNode<>(41);
        root.left.left.left.left = new TreeNode<>(51);

        root.right = new TreeNode<>(22);
        root.right.right = new TreeNode<>(32);
        root.right.right.right = new TreeNode<>(42);
        root.right.right.right.right = new TreeNode<>(52);
        return root;
    }

    private static void print(TreeNode<Integer> root, Consumer<Boolean> expected) {
        log.info("Input:: TreeNode: {} ", root);
        expected.accept(isBalanced(root).isBalanced);
    }

    private static BalancedHeight isBalanced(TreeNode<Integer> current) {
        // BASE CONDITION
        if (current == null) return new BalancedHeight(0, true);

        // HYPOTHESIS
        BalancedHeight left = isBalanced(current.left);
        BalancedHeight right = isBalanced(current.right);

        // INDUCTION
        int height = 1 + Math.max(left.height, right.height);
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        return new BalancedHeight(height, isBalanced);
    }

    record BalancedHeight(int height, boolean isBalanced) {
    }
}
