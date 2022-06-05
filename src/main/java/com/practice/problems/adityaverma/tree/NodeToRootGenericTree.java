package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class NodeToRootGenericTree {

    public static void main(String[] args) {
        log.info("=====FindInGenericTree======");
        assertEquals(List.of(110, 80, 30, 10), nodeToRoot(getSampleTree1(), 110));
        assertEquals(List.of(10), nodeToRoot(getSampleTree1(), 10));
        assertEquals(List.of(), nodeToRoot(getSampleTree1(), 1110));
    }

    public static List<Integer> nodeToRoot(Node<Integer> node, int search) {
        if (node.data() == search) return new ArrayList<>() {{
            add(node.data());
        }};

        // HYPOTHESIS
        for (Node child : node.children()) {
            List<Integer> result = nodeToRoot(child, search);
            if (!result.isEmpty()) {
                result.add(node.data());
                return result;
            }
        }

        // INDUCTION
        return new ArrayList<>();
    }
}
