package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class Traversals {

    public static void main(String[] args) {
        traversals(getSampleTree1());
    }

    public static void traversals(Node<Integer> element) {
        //BASE CONDITION
        if (element == null) return;

        //HYPOTHESIS && INDUCTION
        log.info("Node Pre: {} ", element.data());
        for (Node child : element.children()) {
            log.info("Edge  Pre: {} {}", element.data(), child.data());
            traversals(child);
            log.info("Edge Post: {} {}", element.data(), child.data());
        }
        log.info("Node Post: {}", element.data());
    }
}
