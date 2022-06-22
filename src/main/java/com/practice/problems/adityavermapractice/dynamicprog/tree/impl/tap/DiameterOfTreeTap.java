package com.practice.problems.adityavermapractice.dynamicprog.tree.impl.tap;


import com.practice.problems.adityavermapractice.dynamicprog.tree.DiameterOfTree;
import com.practice.problems.adityavermapractice.dynamicprog.tree.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTreeTap extends DiameterOfTree {

    @Override
    protected Integer diameter(TreeNode<Integer> root, AtomicInteger resDiameter) {
        /* BASE CONDITION */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int leftHeight = diameter(root.left, resDiameter);
        int rightHeight = diameter(root.right, resDiameter);

        /* INDUCTION */
        int height = Math.max(leftHeight, rightHeight) + 1;
        int diameter = leftHeight + rightHeight + 1;
        resDiameter.set(Math.max(Math.max(diameter, height), resDiameter.get()));

        return height;
    }

}
