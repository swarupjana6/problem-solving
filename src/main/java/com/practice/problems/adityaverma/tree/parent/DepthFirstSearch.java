package com.practice.problems.adityaverma.tree.parent;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class DepthFirstSearch {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);

        root.right = new TreeNode<>(21);
        root.right.right = new TreeNode<>(22);
        root.right.right.right = new TreeNode<>(23);
        root.right.right.right.right = new TreeNode<>(14);

        root.left = new TreeNode<>(11);
        root.left.left = new TreeNode<>(12);
        root.left.left.left = new TreeNode<>(13);
        root.left.left.left.left = new TreeNode<>(14);
        print(root, levelOrder -> assertEquals(List.of(1, 11, 12, 13, 14, 21, 22, 23, 14), levelOrder));
    }

    private static void print(TreeNode<Integer> root, Consumer<List<Integer>> expected) {
        log.info("Input:: TreeNode: {} ", root);
        List<Integer> result = depthFirstIterative(root);
        expected.accept(result);

        result = new ArrayList<>();
        depthFirstRecursive(root, result);
        Collections.reverse(result);
        expected.accept(result);
    }

    private static List<Integer> depthFirstIterative(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> current = stack.poll();
            if (current == null) continue;

            stack.push(current.left);
            stack.push(current.right);

            result.add(current.val);
        }
        return result;
    }

    private static void depthFirstRecursive(TreeNode<Integer> current, List<Integer> result) {
        // BASE CONDITION
        if (current == null) return;

        // HYPOTHESIS
        depthFirstRecursive(current.left, result);
        depthFirstRecursive(current.right, result);

        // INDUCTION
        result.add(current.val);
    }
}
