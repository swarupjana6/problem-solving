package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class CeilFloorOfGenericTree {

    public static void main(String[] args) {
        solve(getSampleTree1(), 65, 70, 60);
        solve(getSampleTree1(), 5, 10, Integer.MIN_VALUE);
        solve(getSampleTree1(), 125, Integer.MAX_VALUE, 120);
    }

    private static void solve(Node<Integer> root, int number, int expectedCeil, int expectedFloor) {
        log.info("Input:: Root: {}", root);
        log.info(getLevelOrder(root));
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        floorCeil(root, number);
        assertEquals(expectedCeil, ceil);
        assertEquals(expectedFloor, floor);
    }

    static int ceil = 0;
    static int floor = 0;

    private static void floorCeil(Node<Integer> node, int data) {
        //INDUCTION
        if (node.data() > data && node.data() < ceil) ceil = node.data();
        if (node.data() < data && node.data() > floor) floor = node.data();

        //HYPOTHESIS
        for (Node<Integer> child : node.children()) floorCeil(child, data);
    }
}
