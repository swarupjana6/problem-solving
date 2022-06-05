package com.practice.problems.adityaverma.tree.parent;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenericTree {

    static List<Integer> eulerPath_1 = List.of(10, 20, 50, -1, 60, -1, -1,
            30, 70, -1, 80, 110, -1, 120, -1, -1
            , 90, -1, -1, 40, 100, -1, -1, -1);

    static List<Integer> eulerPathWithNeg = List.of(10, 20, -50, -1, -60, -1, -1,
            30, -70, -1, 80, -110, -1, 120, -1, -1
            , 90, -1, -1, 40, -100, -1, -1, -1);

    static List<Integer> eulerPath_12 = List.of(10, 20, 50, -1, 60);

    static List<Integer> eulerPath_21 = List.of(10, 20, 60, -1, 50);

    static List<Integer> eulerPath_symmetric = List.of(10, 20, 50, -1, 50);

    static List<Integer> eulerPath_2 = List.of(10, 40, 100, -1, 90, -1, -1,
            30, 80, -1, 70, 120, -1, 110, -1, -1
            , 60, -1, -1, 20, 50, -1, -1, -1);

    static List<Integer> eulerPath_3 = List.of(10, 20, 50, -1, 60, -1, -1,
            30, 70, -1, 80, 110, -1
            , 90, -1, -1, 40, 100, -1, -1, -1);

    public static void main(String[] args) {
        System.out.println(getSampleTree1());
        System.out.println(getSampleTree2());
    }

    public static Node<Integer> getSampleTreeSymmetric() {
        return create(eulerPath_symmetric);
    }

    public static Node<Integer> getSampleTreeWithNeg() {
        return create(eulerPathWithNeg);
    }

    public static Node<Integer> getSampleTree12() {
        return create(eulerPath_12);
    }

    public static Node<Integer> getSampleTree21() {
        return create(eulerPath_21);
    }

    public static Node<Integer> getSampleTree1() {
        return create(eulerPath_1);
    }

    public static Node<Integer> getSampleTree2() {
        return create(eulerPath_2);
    }

    public static Node<Integer> getSampleTree3() {
        return create(eulerPath_3);
    }

    public static Node<Integer> create(List<Integer> nodeVals) {
        Node<Integer> root = null;
        Deque<Node<Integer>> stack = new LinkedList<>();

        for (Integer val : nodeVals) {
            if (val == -1) {
                stack.pop();
            } else {
                Node<Integer> node = getNode(val);

                if (!stack.isEmpty()) stack.peek().children().add(node);
                else root = node;

                stack.push(node);
            }
        }

        return root;
    }

    private static Node<Integer> getNode(Integer nodeVal) {
        return new Node<>(nodeVal);
    }
}
