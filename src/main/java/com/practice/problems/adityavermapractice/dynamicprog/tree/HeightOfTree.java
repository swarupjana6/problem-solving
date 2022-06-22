package com.practice.problems.adityavermapractice.dynamicprog.tree;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class HeightOfTree {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract Integer height(TreeNode<Integer> root);

    public void execute() {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(10);
        root.right.right = new TreeNode<>(5);
        root.right.right.left = new TreeNode<>(14);
        root.right.right.left.right = new TreeNode<>(15);
        Integer actualRecursive;
        Integer expected;

        expected = 5;
        actualRecursive = height(root);
        log.debug(LOG_STR, getClass().getSimpleName(), actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
    }
}
