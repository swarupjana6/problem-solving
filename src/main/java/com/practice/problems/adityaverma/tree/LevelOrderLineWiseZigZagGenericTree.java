package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class LevelOrderLineWiseZigZagGenericTree {

    public static void main(String[] args) {
        log.info("Iterative: ");
        levelOrderIterative(getSampleTree1());
        System.out.println("----------------------");
        levelOrderRecursive(getSampleTree1(), 1);
        String output = levelMap.entrySet().stream().map(entry -> {
            StringJoiner values = new StringJoiner(",");
            Deque<Integer> value = entry.getValue();
            if (entry.getKey() % 2 == 0) while (!value.isEmpty()) values.add(value.pop().toString());
            else while (!value.isEmpty()) values.add(value.poll().toString());
            return entry.getKey() + " -> " + values;
        }).collect(Collectors.joining("\n", "Recursive: \n", ""));
        log.info(output);
    }

    public static void levelOrderIterative(Node<Integer> root) {
        Map<Integer, String> result = new HashMap<>();
        int level = 1;
        StringJoiner levelNodes = new StringJoiner(",");

        Deque<Node> mainStack = new ArrayDeque<>();
        mainStack.add(root);

        Deque<Node> childStack = new ArrayDeque<>();
        while (!mainStack.isEmpty()) {
            Node<Integer> current = mainStack.pop();
            levelNodes.add(current.data().toString());

            List<Node<Integer>> children = current.children();
            if (level % 2 == 1) for (Node child : children) childStack.push(child);
            else for (int i = children.size() - 1; i >= 0; i--) childStack.push(children.get(i));

            if (mainStack.size() == 0) {
                mainStack = childStack;
                childStack = new ArrayDeque<>();
                System.out.println(level + " -> " + levelNodes);
                ++level;
                levelNodes = new StringJoiner(",");
            }
        }
    }

    static Map<Integer, Deque<Integer>> levelMap = new HashMap<>();

    public static void levelOrderRecursive(Node<Integer> element, int level) {
        // BASE CONDITION
        if (element == null) return;

        // HYPOTHESIS
        for (Node child : element.children()) levelOrderRecursive(child, level + 1);

        // INDUCTION
        levelMap.compute(level, (k, v) -> {
            if (v == null) v = new ArrayDeque<>();
            if (level % 2 == 0) v.push(element.data());
            else v.offer(element.data());
            return v;
        });
    }
}
