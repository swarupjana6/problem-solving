package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class DistanceBetweenTwoNodes {

    public static void main(String[] args) {
        print(getSampleTree1(), new Node<>(70), new Node<>(110), lca -> assertEquals(3, lca));
        print(getSampleTree1(), new Node<>(50), new Node<>(100), lca -> assertEquals(4, lca));
        print(getSampleTree1(), new Node<>(110), new Node<>(120), lca -> assertEquals(2, lca));
    }

    private static void print(Node<Integer> tree, Node<Integer> first, Node<Integer> second, Consumer<Integer> expected) {
        log.info("Input:: First: {}, Second: {}", first, second);
        log.info(getLevelOrder(tree));
        expected.accept(distanceBetweenTwoNodes(tree, first, second));
    }

    private static Integer distanceBetweenTwoNodes(Node<Integer> tree, Node<Integer> first, Node<Integer> second) {
        List<Node<Integer>> pathFirst = nodeToRoot(tree, first);
        List<Node<Integer>> pathSecond = nodeToRoot(tree, second);

        int firstPathIndex = pathFirst.size();
        int secondPathIndex = pathSecond.size();
        while (firstPathIndex > 0 && secondPathIndex > 0 && pathFirst.get(--firstPathIndex) == pathSecond.get(--secondPathIndex)) {
        }

        return firstPathIndex + secondPathIndex;
    }

    public static List<Node<Integer>> nodeToRoot(Node<Integer> node, Node<Integer> search) {
        if (node.data == search.data) return new ArrayList<>() {{
            add(node);
        }};

        for (Node<Integer> child : node.children()) {
            List<Node<Integer>> path = nodeToRoot(child, search);
            if (!path.isEmpty()) {
                path.add(child);
                return path;
            }
        }

        return new ArrayList<>();
    }
}
