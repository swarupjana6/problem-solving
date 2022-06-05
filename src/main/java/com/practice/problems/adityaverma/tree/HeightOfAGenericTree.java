package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeightOfAGenericTree {

    public static void main(String[] args) {
        // For nodes
        assertEquals(4, height(getSampleTree1()));

        // For edges
        assertEquals(3, height(getSampleTree1()) - 1);
    }

    public static int height(Node<Integer> element) {
        //BASE CONDITION
        if (element == null) return 0;

        //HYPOTHESIS
        int height = 0;
        for (Node node : element.children()) height = Math.max(height, height(node));

        //INDUCTION
        return 1 + height;
    }
}
