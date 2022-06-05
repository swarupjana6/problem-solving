package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree3;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class TreesSimilar {

    public static void main(String[] args) {
        print(getSampleTree1(), getSampleTree1(), lca -> assertEquals(true, lca));
        print(getSampleTree1(), getSampleTree3(), lca -> assertEquals(false, lca));
    }

    private static void print(Node<Integer> first, Node<Integer> second, Consumer<Boolean> expected) {
        log.info("Input:: First: {}, Second: {}", first, second);
        log.info(getLevelOrder(first));
        expected.accept(treeSimilar(first, second));
    }

    private static boolean treeSimilar(Node<Integer> first, Node<Integer> second) {
        int firstSize = first.children().size();
        int secondSize = second.children().size();
        if (firstSize != secondSize) return false;

        for (int index = 0; index < firstSize; index++) {
            Node<Integer> firstsChild = first.children().get(index);
            Node<Integer> secondsChild = second.children().get(index);
            if (treeSimilar(firstsChild, secondsChild) == false) return false;
        }

        return true;
    }
}
