package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class KthSmallest {

    public static void main(String[] args) {
        print(getInput1(), 3, levelOrder -> assertEquals(2, levelOrder));
    }

    private static TreeNode<Integer> getInput1() {
        TreeNode<Integer> root;
        root = new TreeNode<>(3);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(4);
        root.left.left = new TreeNode<>(0);
        root.left.right = new TreeNode<>(2);
        return root;
    }

    private static void print(TreeNode<Integer> root, Integer kth, Consumer<Integer> expected) {
        log.info("Input:: TreeNode: {} ", root);
        expected.accept(kthSmallest(root, kth).val);
        //expected.accept(kthSmallestItr(root, kth));
    }

    static Integer count = 0;

    private static TreeNode<Integer> kthSmallest(TreeNode<Integer> element, Integer kth) {
        //BASE CONDITION
        if (element == null) return null;

        //HYPOTHESIS
        TreeNode left = kthSmallest(element.left, kth);
        if (left != null) return left;
        if (kth == ++count) return element;
        TreeNode right = kthSmallest(element.right, kth);

        return right;
    }

    private static Integer kthSmallestItr(TreeNode<Integer> current, Integer kth) {
        int n = 0;
        Deque<TreeNode<Integer>> stack = new LinkedList<>();

        while (current != null && !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            n += 1;
            if (n == kth) return current.val;
            current = current.right;
        }

        return null;
    }
}
