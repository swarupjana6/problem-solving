package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class FindInGenericTree {

    public static void main(String[] args) {
        log.info("=====FindInGenericTree======");
        assertEquals(true, findNode(getSampleTree1(), 110));
        assertEquals(true, findNode(getSampleTree1(), 10));
        assertEquals(false, findNode(getSampleTree1(), 1110));
    }

    public static boolean findNode(Node<Integer> node, int search) {
        if (node.data() == search) return true;

        // HYPOTHESIS
        for (Node child : node.children()) if (findNode(child, search)) return true;

        // INDUCTION
        return false;
    }
}
