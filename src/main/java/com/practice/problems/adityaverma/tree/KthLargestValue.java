package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class KthLargestValue {

    public static void main(String[] args) {
        solve(getSampleTree1(), 65, 3, 90);
        solve(getSampleTree1(), 5, 3, 30);
        solve(getSampleTree1(), 125, 3, Integer.MAX_VALUE);
    }

    private static void solve(Node<Integer> root, int number, int k, int expectedKthLargest) {
        log.info("Input:: Root: {}", root);
        log.info(getLevelOrder(root));
        kthLargestValue = Integer.MAX_VALUE;
        kth = k;
        floorCeil(root, number);
        assertEquals(expectedKthLargest, kthLargestValue);
    }

    static int kthLargestValue = 0;

    static int kth = 0;

    private static void floorCeil(Node<Integer> node, int data) {
        //INDUCTION
        if (node.data() > data && node.data() < kthLargestValue && --kth == 0) kthLargestValue = node.data();

        //HYPOTHESIS
        for (Node<Integer> child : node.children()) floorCeil(child, data);
    }
}
