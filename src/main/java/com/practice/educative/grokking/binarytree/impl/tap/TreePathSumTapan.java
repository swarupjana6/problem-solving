package com.practice.educative.grokking.binarytree.impl.tap;

import com.practice.educative.grokking.binarytree.TreeNode;
import com.practice.educative.grokking.binarytree.TreePathSum;

public class TreePathSumTapan extends TreePathSum {

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
