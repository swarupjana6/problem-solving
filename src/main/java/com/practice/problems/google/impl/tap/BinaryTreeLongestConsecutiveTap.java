package com.practice.problems.google.impl.tap;

import com.practice.problems.google.BinaryTreeLongestConsecutive;
import com.practice.problems.google.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeLongestConsecutiveTap extends BinaryTreeLongestConsecutive {

    @Override
    protected Integer longestConsecutive(TreeNode<Integer> root) {
        AtomicInteger maxValue = new AtomicInteger(0);
        consecutivePath(root, 0, 0, maxValue);
        return maxValue.get();
    }

    private void consecutivePath(TreeNode<Integer> root, Integer count, Integer target, AtomicInteger maxValue) {
        //BASE CONDITION
        if (root == null) return;
        else if (root.val == target) count++;
        else count = 1;

        //INDUCTION
        maxValue.set(Math.max(count, maxValue.get()));

        //HYPOTHESIS
        consecutivePath(root.left, count, root.val + 1, maxValue);
        consecutivePath(root.right, count, root.val + 1, maxValue);
    }
}
