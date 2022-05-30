package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumInGenericTree {

    public static void main(String[] args) {
        assertEquals(120, maxElement(getSampleTree1(), Integer.MIN_VALUE));
    }

    public static int maxElement(Node<Integer> element, Integer currentMax) {
        //BASE CONDITION
        if (element == null) return currentMax;

        //HYPOTHESIS
        for (Node node : element.children()) currentMax = Math.max(currentMax, maxElement(node, currentMax));

        //INDUCTION
        return Math.max(element.data(), currentMax);
    }
}
