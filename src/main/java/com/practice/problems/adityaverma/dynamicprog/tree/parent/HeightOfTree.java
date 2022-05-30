package com.practice.problems.adityaverma.dynamicprog.tree.parent;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class HeightOfTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(10);
        root.right.right = new TreeNode<>(5);
        root.right.right.left = new TreeNode<>(14);
        root.right.right.left.right = new TreeNode<>(15);
        print(root, maxHeight -> assertEquals(5, maxHeight));
    }

    private static void print(TreeNode root, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {} ", root);
        int height = height(root);
        log.info("Output:: Height of tree is `{}` ", height);
        expected.accept(height);
    }

    public static int height(TreeNode<Integer> root) {
        /* BASE CONDITION */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        /* INDUCTION */
        int height = 1 + Math.max(leftHeight, rightHeight);
        return height;
    }
}
