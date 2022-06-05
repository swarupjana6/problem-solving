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
public class LowestCommonAncestorGeneric {

    public static void main(String[] args) {
        print(getSampleTree1(), new Node<>(50), new Node<>(110), lca -> assertEquals(10, lca));
        print(getSampleTree1(), new Node<>(70), new Node<>(90), lca -> assertEquals(30, lca));
        print(getSampleTree1(), new Node<>(70), new Node<>(120), lca -> assertEquals(30, lca));
    }

    private static void print(Node<Integer> tree, Node<Integer> first, Node<Integer> second, Consumer<Integer> expected) {
        log.info("Input:: First: {}, Second: {}", first, second);
        log.info(getLevelOrder(tree));
        expected.accept(lowestCommonAncestor(tree, first, second).data);
    }

    private static Node<Integer> lowestCommonAncestor(Node<Integer> tree, Node<Integer> first, Node<Integer> second) {
        List<Node<Integer>> pathFirst = nodeToRoot(tree, first);
        List<Node<Integer>> pathSecond = nodeToRoot(tree, second);

        int firstPathIndex = pathFirst.size();
        int secondPathIndex = pathSecond.size();
        while (firstPathIndex > 0 && secondPathIndex > 0 && pathFirst.get(--firstPathIndex) == pathSecond.get(--secondPathIndex)) {
        }

        return pathFirst.get(++firstPathIndex);
    }

    public static List<Node<Integer>> nodeToRoot(Node<Integer> node, Node<Integer> search) {
        if (node.data() == search.data()) return new ArrayList<>() {{
            add(node);
        }};

        // HYPOTHESIS
        for (Node<Integer> child : node.children()) {
            List<Node<Integer>> result = nodeToRoot(child, search);
            if (!result.isEmpty()) {
                result.add(node);
                return result;
            }
        }

        // INDUCTION
        return new ArrayList<>();
    }
}
