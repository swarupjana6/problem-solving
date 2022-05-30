package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class PredecessorSuccessor {

    public static void main(String[] args) {
        solve(getSampleTree1(), 120, 110, 90);
        solve(getSampleTree1(), 40, 90, 100);
    }

    private static void solve(Node<Integer> root, int search, int pre, int suc) {
        log.info("Input:: Root: {}", root);
        log.info(getLevelOrder(root));
        predecessor = null;
        successor = null;
        state = 0;
        predecessorSuccessor(root, new Node<>(search));
        assertEquals(pre, predecessor.data());
        assertEquals(suc, successor.data());
    }

    static Node<Integer> predecessor;
    static Node<Integer> successor;
    static int state = 0;

    private static void predecessorSuccessor(Node<Integer> node, Node<Integer> search) {
        if (state == 0) {
            if (node.data() == search.data()) {
                state = 1;
            } else predecessor = node;
        } else if (state == 1) {
            successor = node;
            state = 2;
            return;
        }

        for (Node<Integer> child : node.children()) predecessorSuccessor(child, search);
    }
}
