package com.practice.problems.adityaverma.tree.parent;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import com.practice.problems.adityaverma.dynamicprog.tree.parent.HeightOfTree;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class BreadthFirstSearch {

    public static void main(String[] args) {
        print(getInput1(), levelOrder -> assertEquals(List.of(1, 21, 22, 31, 32, 41, 42, 51, 52), levelOrder));
        print(getInput2(), levelOrder -> assertEquals(List.of(1, 21, 22, 31, 32, 33, 34), levelOrder));
    }

    private static TreeNode<Integer> getInput2() {
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

    private static TreeNode<Integer> getInput1() {
        TreeNode<Integer> root = new TreeNode<>(1);

        root.left = new TreeNode<>(21);
        root.left.left = new TreeNode<>(31);
        root.left.left.left = new TreeNode<>(41);
        root.left.left.left.left = new TreeNode<>(51);

        root.right = new TreeNode<>(22);
        root.right.right = new TreeNode<>(32);
        root.right.right.right = new TreeNode<>(42);
        root.right.right.right.right = new TreeNode<>(52);
        return root;
    }

    private static void print(TreeNode<Integer> root, Consumer<List<Integer>> expected) {
        log.info("Input:: TreeNode: {} ", root);
        List<Integer> result = breadthFirstIterative(root);
        expected.accept(result);

        Map<Integer, List<Integer>> result1 = new HashMap<>();
        int height = HeightOfTree.height(root);
        breadthFirstRecursive(root, result1, height);
        result = result1.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(entry -> entry.getValue())
                .flatMap(List::stream).collect(Collectors.toList());
        expected.accept(result);
    }

    private static List<Integer> breadthFirstIterative(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> current = queue.poll();
            if (current == null) continue;

            queue.add(current.left);
            queue.add(current.right);

            result.add(current.val);
        }
        return result;
    }

    private static void breadthFirstRecursive(TreeNode<Integer> current, Map<Integer, List<Integer>> result, int level) {
        // BASE CONDITION
        if (current == null) return;

        // HYPOTHESIS
        breadthFirstRecursive(current.left, result, level - 1);
        breadthFirstRecursive(current.right, result, level - 1);

        // INDUCTION
        result.compute(level, (k, v) -> {
            if (v == null) v = new LinkedList<>();
            v.add(current.val);
            return v;
        });
    }
}
