package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class LinearizeAGenericTree {

    public static void main(String[] args) {
        log.info("=====LinearizeAGenericTree======");
        Node<Integer> node = getSampleTree1();
        log.info(getLevelOrder(node));
        linearize(node);
        log.info(getLevelOrder(node));

        node = getSampleTree1();
        log.info(getLevelOrder(node));
        linearizeAndGetLast(node);
        log.info(getLevelOrder(node));
    }

    public static void linearize(Node<Integer> node) {
        // BASE CONDITION
        if (node.children().size() == 0) return;

        // HYPOTHESIS
        for (Node<Integer> child : node.children()) linearize(child);

        // INDUCTION
        while (node.children().size() > 1) {
            Node<Integer> ultimate = node.children().remove(node.children().size() - 1);
            Node<Integer> penultimate = node.children().get(node.children().size() - 1);
            Node<Integer> penultimateTail = nodeTail(penultimate);
            penultimateTail.children(List.of(ultimate));
        }
    }

    private static Node<Integer> nodeTail(Node<Integer> penultimate) {
        Node<Integer> node = penultimate;
        while (node.children().size() > 0) node = node.children().get(0);
        return node;
    }

    public static Node<Integer> linearizeAndGetLast(Node<Integer> node) {
        // BASE CONDITION
        if (node.children().size() == 0) return node;

        // HYPOTHESIS
        Node<Integer> ultimateChild = node.children().get(node.children().size() - 1);
        Node<Integer> linearizedTail = linearizeAndGetLast(ultimateChild);
        while (node.children().size() > 1) {
            Node<Integer> lastChild = node.children().remove(node.children().size() - 1);
            Node<Integer> secondLastChild = node.children().get(node.children().size() - 1);
            linearizeAndGetLast(secondLastChild).children(List.of(lastChild));
        }

        // INDUCTION
        return linearizedTail;
    }
}
