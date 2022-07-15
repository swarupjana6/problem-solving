package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.function.BiConsumer;

@Log4j2
public abstract class ConvertSortedArrayToBST {

    final BiConsumer<TreeNode<Integer>, TreeNode<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract TreeNode<Integer> convertToBST(Integer[] inputArr);

    public void execute() {
        Integer[] sortedArr;
        TreeNode<Integer> actual;
        TreeNode<Integer> expected;

        sortedArr = new Integer[]{-10, -3, 0, 5, 9};
        expected = getSample1();
        actual = convertToBST(Arrays.copyOf(sortedArr, sortedArr.length));
        log.debug(LOG_STR, getClass().getSimpleName(), sortedArr, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }

    private TreeNode<Integer> getSample1() {
        TreeNode<Integer> root1 = new TreeNode<>(0);
        root1.left = new TreeNode<>(-3);
        root1.right = new TreeNode<Integer>(9);
        root1.right.left = new TreeNode<Integer>(-10);
        root1.right.left = new TreeNode<Integer>(5);
        return root1;
    }
}
