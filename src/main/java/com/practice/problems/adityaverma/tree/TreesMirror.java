package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree12;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree21;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class TreesMirror {

    public static void main(String[] args) {
        //print(getSampleTree1(), getSampleTree1(), lca -> assertEquals(false, lca));
        print(getSampleTree12(), getSampleTree21(), lca -> assertEquals(true, lca));
    }

    public static void print(Node<Integer> first, Node<Integer> second, Consumer<Boolean> expected) {
        log.info("Input:: First: {}, Second: {}", first, second);
        log.info(getLevelOrder(first));
        log.info(getLevelOrder(second));
        expected.accept(isMirror(first, second));
    }

    private static boolean isMirror(Node<Integer> first, Node<Integer> second) {
        int firstSize = first.children().size();
        int secondSize = second.children().size();
        if (firstSize != secondSize) return false;

        for (int index = 0; index < firstSize; index++) {
            int mirrorIndex = secondSize - 1 - index;
            Node<Integer> firstsChild = first.children().get(index);
            Node<Integer> secondsChild = second.children().get(mirrorIndex);
            if (isMirror(firstsChild, secondsChild) == false) return false;
        }

        return true;
    }
}
