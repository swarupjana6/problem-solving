package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class MirrorOfATree {

    public static void main(String[] args) {
        log.info("=====MirrorOfATree======");
        Node<Integer> node = mirrorNode(getSampleTree1());
        log.info(LevelOrderLineWiseGenericTree.getLevelOrder(node));
    }

    public static Node<Integer> mirrorNode(Node<Integer> node) {
        // BASE CONDITION
        if (node == null) return null;

        // HYPOTHESIS
        for (Node child : node.children()) mirrorNode(child);

        // INDUCTION
        List<Node<Integer>> mirroredChildren = new ArrayList<>(node.children());
        Collections.reverse(mirroredChildren);
        node.children(mirroredChildren);
        return node;
    }
}
