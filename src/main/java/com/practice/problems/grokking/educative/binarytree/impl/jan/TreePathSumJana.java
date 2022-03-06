package com.practice.problems.grokking.educative.binarytree.impl.jan;

import com.practice.problems.grokking.educative.binarytree.TreeNode;
import com.practice.problems.grokking.educative.binarytree.TreePathSum;

public class TreePathSumJana extends TreePathSum {

    @Override
    public boolean hasPath(TreeNode<Integer> node, Integer sum) {

        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null && node.value == sum) {
            return true;
        }

        return hasPath(node.left, sum - node.value) || hasPath(node.right, sum - node.value);
    }
}
