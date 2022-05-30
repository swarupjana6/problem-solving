package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class LevelOrderBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.right.right = new TreeNode<>(5);
        print(root, levelOrder -> assertEquals(null, levelOrder));
    }

    private static void print(TreeNode<Integer> root, Consumer<List<List<Integer>>> expected) {
        log.info("Input:: TreeNode: {} ", root);
        /*Map<Integer, List<Integer>> levelMap = new HashMap<>();
        levelOrder(root, levelMap);
        log.info("Output:: Height of tree is `{}` ", levelMap.values());
        List<List<Integer>> obs = levelMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).map(entry -> entry.getValue()).collect(Collectors.toList());*/
        List<List<Integer>> obs;
        obs = levelOrder(root);
        System.out.println(obs);
    }

    private static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = nodes.poll();
                if (node != null) {
                    level.add(node.val);
                    nodes.add(node.left);
                    nodes.add(node.right);
                }
            }
            if (level.size() > 0) result.add(level);
        }

        return result;
    }
}
