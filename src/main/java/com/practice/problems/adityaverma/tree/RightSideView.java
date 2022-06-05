package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class RightSideView {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.right.right = new TreeNode<>(5);
        print(root, levelOrder -> assertEquals(List.of(1, 3, 5), levelOrder));

        root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);
        root.right.right.left = new TreeNode<>(4);
        root.right.right.left.right = new TreeNode<>(5);
        print(root, levelOrder -> assertEquals(List.of(1, 2, 3, 4, 5), levelOrder));

        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        print(root, levelOrder -> assertEquals(List.of(1, 2), levelOrder));
    }

    private static void print(TreeNode<Integer> root, Consumer<List<Integer>> expected) {
        log.info("Input:: TreeNode: {} ", root);
        List<Integer> result = rightSide(root);
        log.info(result);
        expected.accept(result);
    }

    private static List<Integer> rightSide(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = nodes.poll();
                if (node != null) {
                    level.add(node.val);
                    nodes.add(node.left);
                    nodes.add(node.right);
                }
            }
            if (level.size() > 0) {
                int last = level.size() > 0 ? level.size() - 1 : 0;
                result.add(level.get(last));
            }
        }

        return result;
    }
}
