package com.practice.educative.grokking.binarytree;

import com.practice.educative.grokking.binarytree.impl.jan.TreePathSumJana;

public abstract class TreePathSum {

    public abstract boolean hasPath(TreeNode<Integer> node, Integer sum);

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(9);
        root.right.left = new TreeNode<>(10);
        root.right.right = new TreeNode<>(5);
        System.out.println("Tree has path: " + new TreePathSumJana().hasPath(root, 23));
        System.out.println("Tree has path: " + new TreePathSumJana().hasPath(root, 16));
    }
}
