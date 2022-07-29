package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class BinaryTreeLongestConsecutive {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer longestConsecutive(TreeNode<Integer> root);

    public void execute() {
        TreeNode<Integer> root;
        Integer actual;
        Integer expected;

        root = getSample1();
        expected = 3;
        actual = longestConsecutive(root);
        log.debug(LOG_STR, getClass().getSimpleName(), root, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        root = getSample2();
        expected = 1;
        actual = longestConsecutive(root);
        log.debug(LOG_STR, getClass().getSimpleName(), root, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }

    private TreeNode<Integer> getSample1() {
        TreeNode<Integer> root1 = new TreeNode<>(1);
        root1.right = new TreeNode<>(3);
        root1.right.left = new TreeNode<>(2);
        root1.right.right = new TreeNode<>(4);
        root1.right.right.left = new TreeNode<>(5);
        return root1;
    }

    private TreeNode<Integer> getSample2() {
        TreeNode<Integer> root1 = new TreeNode<>(1);
        root1.right = new TreeNode<>(31);
        root1.right.left = new TreeNode<>(21);
        root1.right.right = new TreeNode<>(41);
        root1.right.left.right = new TreeNode<>(51);
        return root1;
    }
}
