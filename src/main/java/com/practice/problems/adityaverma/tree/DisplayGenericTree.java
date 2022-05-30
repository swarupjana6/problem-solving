package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.GenericTree;
import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

@Log4j2
public class DisplayGenericTree {

    public static void main(String[] args) {
        displayTree(GenericTree.getSampleTree1());
    }

    public static void displayTree(Node<Integer> element) {
        //BASE CONDITION
        if (element == null) return;

        //INDUCTION
        log.info(element.data() + "\t->  " + element.children().stream().map(e -> e.data().toString()).collect(Collectors.joining(",")));

        // HYPOTHESIS
        element.children().stream().forEach(DisplayGenericTree::displayTree);
    }
}
