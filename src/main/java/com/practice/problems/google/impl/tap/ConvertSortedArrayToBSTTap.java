package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ConvertSortedArrayToBST;
import com.practice.problems.google.TreeNode;

public class ConvertSortedArrayToBSTTap extends ConvertSortedArrayToBST {

    @Override
    protected TreeNode<Integer> convertToBST(Integer[] inputArr) {
        return getTreeNode(inputArr, 0, inputArr.length - 1);
    }

    private TreeNode<Integer> getTreeNode(Integer[] inputArr, int low, int high) {
        //BASE CONDITION
        if (high < low) return null;

        //HYPOTHESIS
        int mid = low + (high - low) / 2;
        TreeNode<Integer> leftNode = getTreeNode(inputArr, low, mid - 1);
        TreeNode<Integer> rightNode = getTreeNode(inputArr, mid + 1, high);

        //INDUCTION
        return new TreeNode<>(inputArr[mid], leftNode, rightNode);
    }
}
