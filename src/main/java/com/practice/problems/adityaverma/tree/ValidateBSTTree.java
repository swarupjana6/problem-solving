package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class ValidateBSTTree {

    public static void main(String[] args) {
        //print(getInput1(), count -> assertEquals(false, count));
        //print(getInput2(), count -> assertEquals(true, count));
        //print(getInput3(), count -> assertEquals(false, count));
        print(getInput4(), count -> assertEquals(true, count));
    }

    private static TreeNode<Integer> getInput1() {
        TreeNode<Integer> root = new TreeNode<>(3);

        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(4);

        root.left.left = new TreeNode<>(3);
        root.left.right = null;

        root.right.left = new TreeNode<>(1);
        root.right.right = new TreeNode<>(5);

        return root;
    }

    private static TreeNode<Integer> getInput2() {
        TreeNode<Integer> root = new TreeNode<>(3);

        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(4);

        return root;
    }

    private static TreeNode<Integer> getInput3() {
        TreeNode<Integer> root = new TreeNode<>(3);

        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(6);

        return root;
    }

    private static TreeNode<Integer> getInput4() {
        TreeNode<Integer> root = new TreeNode<>(2147483647);
        return root;
    }

    private static void print(TreeNode<Integer> tree, Consumer<Boolean> expected) {
        log.info("Input:: TreeNode: {}", tree);
        expected.accept(isValid(tree, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private static boolean isValid(TreeNode<Integer> current, long leftBoundary, long rightBoundary) {
        //BASE CONDITION
        if (current == null) return true;
        if (!(leftBoundary < current.val && current.val < rightBoundary)) return false;

        // HYPOTHESIS
        boolean isLeftValid = isValid(current.left, leftBoundary, current.val);
        boolean isRightValid = isValid(current.right, current.val, rightBoundary);

        // INDUCTION
        return isLeftValid && isRightValid;
    }
}
