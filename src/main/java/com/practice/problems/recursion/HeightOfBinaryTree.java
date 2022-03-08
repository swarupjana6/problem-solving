package com.practice.problems.recursion;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HeightOfBinaryTree {

    public static void main(String[] args) {
        Node root = getNode1();
        log.info(height(root));
    }

    public static Integer height(Node root) {
        // BASE CONDITION
        if (root == null) return 0;

        // HYPOTHESIS STEP
        int leftHeight = height(root.left());
        int leftRight = height(root.right());

        // INDUCTION STEP
        return 1 + Math.max(leftHeight, leftRight);
    }

    private static Node getNode1() {
        Node node311 = new Node(1, null, null);
        Node node312 = new Node(3, null, null);
        Node node321 = new Node(11, null, null);
        Node node322 = new Node(13, null, null);

        Node node21 = new Node(2, node311, node312);
        Node node22 = new Node(12, node321, node322);

        Node node1 = new Node(10, node21, node22);

        return node1;
    }
}
