package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicInteger;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTreeWithNeg;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class MaxSumSubTree {

    public static void main(String[] args) {
        log.info("=====MaxSumSubTree======");
        log.info(getLevelOrder(getSampleTreeWithNeg()));
        AtomicInteger result = new AtomicInteger();
        maxSumSubTree(getSampleTreeWithNeg(), result);
        assertEquals(140, result.get());
    }

    public static int maxSumSubTree(Node<Integer> node, AtomicInteger result) {
        // BASE CONDITION
        if (node == null) return 0;

        // HYPOTHESIS
        int sum = 0;
        for (Node<Integer> child : node.children()) sum += maxSumSubTree(child, result);

        // INDUCTION
        int currentNodeSum = node.data() + sum;
        result.set(Math.max(currentNodeSum, result.get()));

        return currentNodeSum;
    }
}

