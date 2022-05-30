package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class LowestCommonAncestor {

    public static void main(String[] args) {
        print(getInput1(), new TreeNode(2), new TreeNode(8), lca -> assertEquals(6, lca));
        print(getInput1(), new TreeNode(3), new TreeNode(5), lca -> assertEquals(4, lca));
    }

    private static TreeNode<Integer> getInput1() {
        TreeNode<Integer> root = new TreeNode<>(6);

        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(8);

        root.left.left = new TreeNode<>(0);
        root.left.right = new TreeNode<>(4);

        root.right.left = new TreeNode<>(7);
        root.right.right = new TreeNode<>(9);

        return root;
    }

    private static TreeNode<Integer> getInput2() {
        TreeNode<Integer> root = new TreeNode<>(6);

        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(8);

        root.left.left = new TreeNode<>(0);
        root.left.right = new TreeNode<>(4);

        root.right.left = new TreeNode<>(7);
        root.right.right = new TreeNode<>(9);

        root.left.right.left = new TreeNode<>(3);
        root.left.right.right = new TreeNode<>(5);

        return root;
    }

    private static void print(TreeNode<Integer> tree, TreeNode<Integer> first, TreeNode<Integer> second, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {}", tree);
        expected.accept((Integer) lowestCommonAncestor(tree, first, second).val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode<Integer> tree, TreeNode<Integer> first, TreeNode<Integer> second) {
        //BASE CONDITION
        if (tree == null) return null;

        //HYPOTHESIS
        if (first.val < tree.val && second.val < tree.val) return lowestCommonAncestor(tree.left, first, second);
        else if (first.val > tree.val && second.val > tree.val) return lowestCommonAncestor(tree.right, first, second);
        else return tree;
    }
}
