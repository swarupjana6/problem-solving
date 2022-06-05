package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class MultiSolver {

    static int min;
    static int max;
    static int size;
    static int height;

    public static void main(String[] args) {
        solve(getSampleTree1());
    }

    private static void solve(Node<Integer> root) {
        log.info("Input:: First: {}, Second: {}", root);
        log.info(getLevelOrder(root));
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
        height = 0;
        multiSolver(root, root != null ? 1 : 0);
        assertEquals(10, min);
        assertEquals(120, max);
        assertEquals(4, height);
    }

    private static void multiSolver(Node<Integer> node, int depth) {
        size++;
        min = Math.min(node.data(), min);
        max = Math.max(node.data(), max);
        height = Math.max(height, depth);

        for (Node<Integer> child : node.children()) multiSolver(child, depth + 1);
    }


}
