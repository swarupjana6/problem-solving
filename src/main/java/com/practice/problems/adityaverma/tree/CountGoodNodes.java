package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class CountGoodNodes {

    public static void main(String[] args) {
        print(getInput1(), count -> assertEquals(4, count));
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

    static Integer count = 0;

    private static void print(TreeNode<Integer> tree, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {}", tree);
        countGoodNodes(tree, Integer.MIN_VALUE);
        expected.accept(count);
    }

    private static void countGoodNodes(TreeNode<Integer> current, int maxSoFar) {
        //BASE CONDITION
        if (current == null) return;

        //INDUCTION
        if (current.val >= maxSoFar) {
            maxSoFar = current.val;
            count++;
        }

        //HYPOTHESIS
        if (current.left != null) countGoodNodes(current.left, maxSoFar);
        if (current.right != null) countGoodNodes(current.right, maxSoFar);
    }
}