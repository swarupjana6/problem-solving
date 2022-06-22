package com.practice.problems.adityavermapractice.dynamicprog.tree.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.tree.MaximumPathSum;
import com.practice.problems.adityavermapractice.dynamicprog.tree.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumPathSumTap extends MaximumPathSum {

    @Override
    protected Integer maxPathSum(TreeNode<Integer> root, AtomicInteger resMaxSum) {
        /* BASE CONDITION */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int leftSum = maxPathSum(root.left, resMaxSum);
        int rightSum = maxPathSum(root.right, resMaxSum);

        /* INDUCTION */
        int heightSum = Math.max(leftSum, rightSum) + root.val;
        heightSum = Math.max(heightSum, root.val);

        int diameterSum = leftSum + rightSum + root.val;
        int maxSum = Math.max(diameterSum, heightSum);
        resMaxSum.set(Math.max(maxSum, resMaxSum.get()));

        return heightSum;
    }
}
