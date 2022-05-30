package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class LevelOrderLineWiseGenericTree {

    static Function<Map<Integer, String>, String> MAP_TO_STRING = (nodes) -> nodes.entrySet().stream().map(entry -> entry.getKey() + " -> " + entry.getValue()).collect(Collectors.joining("\n", "\n", ""));

    static Function<Map<Integer, List<Integer>>, String> MAP_TO_STRING_1 = (nodes) -> nodes.entrySet().stream().map(entry -> entry.getKey() + " -> " + entry.getValue()).collect(Collectors.joining("\n", "\n", ""));

    public static void main(String[] args) {
        log.info("\n=====levelOrderWithTwoQueue======" + MAP_TO_STRING.apply(levelOrderWithTwoQueue(getSampleTree1())));
        log.info("\n=====levelOrderWithMarkerNodeOneQueue======" + MAP_TO_STRING.apply(levelOrderWithMarkerNodeOneQueue(getSampleTree1())));
        log.info("\n=====levelOrderIterative3======" + MAP_TO_STRING.apply(levelOrderWithSizeInLevel(getSampleTree1())));
        log.info("\n=====levelOrderPair======" + MAP_TO_STRING.apply(levelOrderPair(getSampleTree1())));

        log.info("=====levelOrderRecursive======");
        levelOrderRecursive(getSampleTree1(), 1);
        log.info(MAP_TO_STRING_1.apply(levelMap));
    }

    public static String getLevelOrder(Node<Integer> node) {
        levelMap = new HashMap<>();
        levelOrderRecursive(node, 1);
        return MAP_TO_STRING_1.apply(levelMap);
    }

    public static Map<Integer, String> levelOrderWithTwoQueue(Node<Integer> node) {
        if (node == null) return null;
        Map<Integer, String> result = new HashMap<>();
        StringJoiner resultNodes = new StringJoiner(",");
        int level = 0;

        Deque<Node> parentQueue = new ArrayDeque<>();
        parentQueue.add(node);
        Deque<Node<Integer>> childQueue = new ArrayDeque<>();
        while (!parentQueue.isEmpty()) {
            node = parentQueue.poll();
            resultNodes.add(node.data().toString());
            addChildrenToQueue(node, childQueue);

            // Check if all the elements in current level is over
            // Prepare the result
            // Move items in children queue to main queue
            if (parentQueue.isEmpty() && !childQueue.isEmpty()) {
                result.put(++level, resultNodes.toString());
                while (!childQueue.isEmpty()) parentQueue.add(childQueue.poll());
                resultNodes = new StringJoiner(",");
            }
        }
        if (resultNodes.length() > 0) result.put(++level, resultNodes.toString());

        return result;
    }

    public static Map<Integer, String> levelOrderWithMarkerNodeOneQueue(Node<Integer> node) {
        Map<Integer, String> result = new HashMap<>();
        Node<Integer> markerNode = new Node<>(-1);
        StringJoiner resultNodes = new StringJoiner(",");
        int level = 1;

        Deque<Node<Integer>> queue = new ArrayDeque<>();

        queue.add(node);
        queue.add(markerNode);

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.data() != -1) {
                resultNodes.add(node.data().toString());
                addChildrenToQueue(node, queue);
            } else {
                if (!queue.isEmpty()) {
                    queue.offer(markerNode);
                    result.put(level++, resultNodes.toString());
                    resultNodes = new StringJoiner(",");
                }
            }
        }
        if (resultNodes.length() > 0) result.put(level, resultNodes.toString());

        return result;
    }

    public static Map<Integer, String> levelOrderWithSizeInLevel(Node<Integer> node) {
        Map<Integer, String> result = new HashMap<>();
        int level = 0;

        Deque<Node<Integer>> queue = new ArrayDeque<>();
        queue.offer(node);

        while (queue.size() > 0) {
            int size = queue.size();
            StringJoiner resultNodes = new StringJoiner(",");
            while (size-- > 0) {
                node = queue.poll();
                resultNodes.add(node.data().toString());
                addChildrenToQueue(node, queue);
            }
            result.put(++level, resultNodes.toString());
        }

        return result;
    }

    record NodePair(Node<Integer> node, int level) {
    }

    public static Map<Integer, String> levelOrderPair(Node<Integer> node) {
        Map<Integer, String> result = new HashMap<>();

        int level = 1;
        Deque<NodePair> queue = new ArrayDeque<>();
        queue.offer(new NodePair(node, level));
        while (queue.size() > 0) {
            StringJoiner resultNodes = new StringJoiner(",");
            while (queue.peek() != null && queue.peek().level == level) {
                NodePair nodePair = queue.poll();
                resultNodes.add(nodePair.node().data().toString());
                addChildrenToQueue(nodePair.node(), queue, level + 1);
            }
            result.put(level++, resultNodes.toString());
        }

        return result;
    }

    private static void addChildrenToQueue(Node<Integer> node, Deque<NodePair> queue, int level) {
        for (Node<Integer> child : node.children()) queue.offer(new NodePair(child, level));
    }

    private static void addChildrenToQueue(Node<Integer> node, Deque<Node<Integer>> queue) {
        for (Node<Integer> child : node.children()) queue.offer(child);
    }

    static Map<Integer, List<Integer>> levelMap = new HashMap<>();

    public static void levelOrderRecursive(Node<Integer> node, int level) {
        // BASE CONDITION
        if (node == null) return;

        // HYPOTHESIS
        for (Node child : node.children()) levelOrderRecursive(child, level + 1);

        // INDUCTION
        levelMap.compute(level, (k, v) -> {
            if (v == null) v = new ArrayList<>();
            v.add(node.data());
            return v;
        });
    }
}
