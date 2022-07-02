package com.practice.interview.tap;

import com.practice.problems.adityaverma.dynamicprog.tree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

interface Traversal<T> {
    List<List<T>> traverse(BinaryTreeNode<T> node);
}

class LevelOrderTraversal<T> implements Traversal<T> {

    @Override
    public List<List<T>> traverse(BinaryTreeNode<T> node) {
        List<List<T>> levelOrder = new ArrayList();
        Map<Integer, List<T>> levelNodesMap = new HashMap<>();
        getLevelOrder(node, 1, levelNodesMap);
        for (Map.Entry<Integer, List<T>> entry : levelNodesMap.entrySet()) {
            levelOrder.add(entry.getValue());
        }

        return levelOrder;
    }

    private void getLevelOrder(BinaryTreeNode<T> node, Integer level, Map<Integer, List<T>> result) {
        if (node == null) return;

        getLevelOrder(node.left, level + 1, result);
        getLevelOrder(node.right, level + 1, result);

        List<T> levelNodes = result.getOrDefault(level, new ArrayList<T>());
        levelNodes.add(node.val);
        result.put(level, levelNodes);
    }
}

class Tree<T> {

    Traversal<T> traversal;

    Tree(Traversal<T> traversal) {
        this.traversal = traversal;
    }

    public List<List<T>> traverse(BinaryTreeNode<T> node) {
        return traversal.traverse(node);
    }

}

public class Narvar {

    public static void main(String[] args) {
        //List<Integer> nodes = List.of(2, 3, 4, 5, 6, 7, 8);
        //Tree<Integer> tree = new Tree(new LevelOrderTraversal<Integer>());
        //System.out.println(tree.traverse(getNode()));
        //solve(85, 100, 95);
        solve1();
    }

    public static void solve1() {
        System.out.println("dasdas");
    }

    public static int solve(int weight0, int weight1, int weight2) {
        int[] ints = {-9, 14, 37, 102};
        int k = 102;
        System.out.println(">>>>>>" + IntStream.rangeClosed(0, ints.length-1).parallel().anyMatch(x -> ints[x] == k));

        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.add(weight0);
        heap.add(weight1);
        heap.add(weight2);
        int peek = heap.peek();
        if (peek == weight0) return 0;
        else if (peek == weight1) return 1;
        else if (peek == weight2) return 2;




        return -1;
    }

    public static TreeNode<Integer> create(int depth) {
        if (depth < 0) return null;
        TreeNode<Integer> currentNode = new TreeNode<>(depth);
        if (depth > 0) {
            currentNode.left = create(depth - 1);
            currentNode.right = create(depth - 1);
        }
        return currentNode;
    }


    private static BinaryTreeNode<Integer> getNode(List<Integer> nodes, int level, int size) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        root.left = new BinaryTreeNode<Integer>(3);
        root.right = new BinaryTreeNode<Integer>(4);

        root.left.left = new BinaryTreeNode<Integer>(5);
        root.left.right = new BinaryTreeNode<Integer>(6);

        root.right.left = new BinaryTreeNode<Integer>(7);
        root.right.right = new BinaryTreeNode<Integer>(8);

        return root;
    }

}

class BinaryTreeNode<T> {
    public T val;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T val) {
        this.val = val;
    }
}
