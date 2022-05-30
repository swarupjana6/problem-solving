package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class SizeOfAGenericTree {

    public static void main(String[] args) {
        assertEquals(12, sizeRecursion(getSampleTree1()));
    }

    public static int sizeRecursion(Node<Integer> element) {
        //BASE CONDITION
        if (element == null) return 0;

        //HYPOTHESIS
        int size = 0;
        for (Node node : element.children()) size += sizeRecursion(node);

        //INDUCTION
        return size + 1;
    }
}
