package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static com.practice.problems.adityaverma.tree.LevelOrderLineWiseGenericTree.getLevelOrder;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class IterativePreOrderPostOrder {

    private static Consumer<Node<Integer>> PRE_POST_ITERATIVE_1 = node -> prePostOrderIterative1(node);

    private static Consumer<Node<Integer>> PRE_POST_ITERATIVE_2 = node -> prePostOrderIterative2(node);

    private static Consumer<Node<Integer>> PRE_POST_RECURSIVE = node -> prePostOrderRecursive(node);

    static StringJoiner preOrder = new StringJoiner(", ");
    static StringJoiner postOrder = new StringJoiner(", ");

    public static void main(String[] args) {
        log.info("=====IterativePreOrderPostOrder======");
        log.info(getLevelOrder(getSampleTree1()));
        log.info("PRE_POST_RECURSIVE");
        prePostOrderFunctionCall(PRE_POST_RECURSIVE, getSampleTree1());
        log.info("PRE_POST_ITERATIVE_1");
        prePostOrderFunctionCall(PRE_POST_ITERATIVE_1, getSampleTree1());
        log.info("PRE_POST_ITERATIVE_2");
        prePostOrderFunctionCall(PRE_POST_ITERATIVE_2, getSampleTree1());
    }

    private static void prePostOrderFunctionCall(Consumer<Node<Integer>> func, Node<Integer> node) {
        preOrder = new StringJoiner(", ");
        postOrder = new StringJoiner(", ");
        func.accept(node);
        log.info(preOrder);
        log.info(postOrder);
    }

    public static void prePostOrderRecursive(Node<Integer> node) {
        if (node == null) return;
        preOrder.add(node.data().toString());
        for (int index = 0; index < node.children().size(); index++) prePostOrderRecursive(node.children().get(index));
        postOrder.add(node.data().toString());
    }

    public static void prePostOrderIterative1(Node<Integer> node) {
        Deque<NodePair> stack = new ArrayDeque<>();
        stack.push(new NodePair(node, -1));

        while (!stack.isEmpty()) {
            NodePair top = stack.peek();

            if (top.index == -1) {
                preOrder.add(top.node.data.toString());
                top.index++;
            } else if (top.index == top.node.children.size()) {
                postOrder.add(top.node.data.toString());
                stack.pop();
            } else {
                stack.push(new NodePair(top.node.children.get(top.index), -1));
                top.index++;
            }
        }
    }

    public static void prePostOrderIterative2(Node<Integer> node) {
        Deque<NodePair> stack = new ArrayDeque<>();
        stack.push(new NodePair(node, -1));

        while (!stack.isEmpty()) {
            NodePair top = stack.peek();

            if (top.index == -1) {
                preOrder.add(top.node.data.toString());
                top.index++;
                continue;
            }

            if (top.index < top.node.children().size()) {
                Node<Integer> child = top.node.children.get(top.index);
                stack.push(new NodePair(child, -1));
                top.index++;
                continue;
            }

            if (top.index == top.node.children.size()) {
                postOrder.add(top.node.data.toString());
                stack.pop();
                continue;
            }
        }

        System.out.println("asdasdsda");
    }

    @AllArgsConstructor
    static class NodePair {
        private Node<Integer> node;
        private Integer index;
    }
}
