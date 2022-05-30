package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicInteger;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTreeWithNeg;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class DiameterOfATree {

    public static void main(String[] args) {
        log.info("=====DiameterOfATree======");
        log.info(getLevelOrder(getSampleTreeWithNeg()));
        AtomicInteger result = new AtomicInteger();
        diameter(getSampleTreeWithNeg(), result);
        assertEquals(6, result.get());
    }

    public static int diameter(Node<Integer> node, AtomicInteger diameter) {
        // BASE CONDITION
        if (node == null) return 0;

        // HYPOTHESIS
        int longest = -1;
        int secondLongest = -1;
        for (Node<Integer> child : node.children()) {
            int nodeHeight = diameter(child, diameter);
            if (nodeHeight > longest) {
                secondLongest = longest;
                longest = nodeHeight;
            } else if (nodeHeight > secondLongest) secondLongest = nodeHeight;
        }

        // INDUCTION
        int currentHeight = 1 + Math.max(longest, secondLongest);
        int currentDiameter = 2 + longest + secondLongest;
        diameter.set(Math.max(currentDiameter, diameter.get()));

        return currentHeight;
    }
}

