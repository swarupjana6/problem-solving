package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree1;

@Log4j2
public class LevelOrderGenericTree {

    public static void main(String[] args) {
        String levelOrder = levelOrder(getSampleTree1()).stream().map(node -> node.data().toString()).collect(Collectors.joining(","));
        System.out.println(levelOrder);
    }

    public static List<Node> levelOrder(Node<Integer> element) {
        if (element == null) return null;
        List<Node> levelOrder = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(element);

        while (!queue.isEmpty()) {
            element = queue.remove();
            levelOrder.add(element);

            for (Node child : element.children()) queue.add(child);
        }

        return levelOrder;
    }
}
