package com.practice.problems.adityaverma.tree.parent;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class TreeTraversal {

    public static void main(String[] args) {
        print(getInput1(), (root, result) -> inOrder(root, result), levelOrder -> assertEquals(List.of(31, 21, 32, 1, 33, 22, 34), levelOrder));
        print(getInput1(), (root, result) -> inOrderIt(root, result), levelOrder -> assertEquals(List.of(31, 21, 32, 1, 33, 22, 34), levelOrder));

        print(getInput1(), (root, result) -> preOrder(root, result), levelOrder -> assertEquals(List.of(1, 21, 31, 32, 22, 33, 34), levelOrder));

        print(getInput1(), (root, result) -> postOrder(root, result), levelOrder -> assertEquals(List.of(31, 32, 21, 33, 34, 22, 1), levelOrder));
    }

    private static TreeNode<Integer> getInput1() {
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

    private static void print(TreeNode<Integer> root, BiConsumer<TreeNode<Integer>, List<Integer>> traversalFunction, Consumer<List<Integer>> expected) {
        log.info("Input:: TreeNode: {} ", root);
        List<Integer> result = new ArrayList<>();
        traversalFunction.accept(root, result);
        expected.accept(result);
    }

    private static void inOrder(TreeNode<Integer> current, List<Integer> result) {
        // BASE CONDITION
        if (current == null) return;

        // HYPOTHESIS && INDUCTION
        inOrder(current.left, result);
        result.add(current.val);
        inOrder(current.right, result);
    }

    private static void inOrderIt(TreeNode<Integer> root, List<Integer> result) {
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> current = root;

        while (!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
    }

    private static void preOrder(TreeNode<Integer> current, List<Integer> result) {
        // BASE CONDITION
        if (current == null) return;

        // HYPOTHESIS && INDUCTION
        result.add(current.val);
        preOrder(current.left, result);
        preOrder(current.right, result);
    }

    private static void postOrder(TreeNode<Integer> current, List<Integer> result) {
        // BASE CONDITION
        if (current == null) return;

        // HYPOTHESIS && INDUCTION
        postOrder(current.left, result);
        postOrder(current.right, result);
        result.add(current.val);
    }
}
