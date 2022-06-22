package com.practice.problems.adityavermapractice.dynamicprog.tree;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

@Log4j2
public abstract class MaximumPathSum {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer maxPathSum(TreeNode<Integer> root, AtomicInteger maxSum);

    public void execute() {
        TreeNode<Integer> root = new TreeNode<>(-10);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(7);

        Integer actualRecursive;
        Integer actualMemoized;
        Integer expected;

        expected = 42;
        AtomicInteger maxPathSum = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSum(root, maxPathSum);
        actualRecursive = maxPathSum.get();
        log.debug(LOG_STR, getClass().getSimpleName(), actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
    }
}
