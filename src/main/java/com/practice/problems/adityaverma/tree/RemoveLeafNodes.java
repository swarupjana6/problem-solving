package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class RemoveLeafNodes {

    public static void main(String[] args) {
        log.info("=====RemoveLeafNodes======");
        Node<Integer> node = getSampleTree1();
        log.info(getLevelOrder(node));
    }

    public static void removeLeaf(Node<Integer> node) {
        // BASE CONDITION
        // if (node == null) return;
        List<Node<Integer>> children = node.children();

        // INDUCTION
        children.removeIf(child -> child.children().size() == 0);

        // HYPOTHESIS
        children.stream().forEach(RemoveLeafNodes::removeLeaf);
    }
}
