package com.practice.problems.adityavermapractice.dynamicprog.tree.impl.tap;


import com.practice.problems.adityavermapractice.dynamicprog.tree.DiameterOfTree;
import com.practice.problems.adityavermapractice.dynamicprog.tree.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTreeTap extends DiameterOfTree {

    @Override
    protected Integer diameter(TreeNode<Integer> root, AtomicInteger diameter) {
        /* BASE CONDITION */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int leftHeight = diameter(root.left, diameter);
        int rightHeight = diameter(root.right, diameter);

        /* INDUCTION */
        int currentHeight = Math.max(leftHeight, rightHeight) + 1;
        int currentDiameter = leftHeight + rightHeight + 1;
        diameter.set(Math.max(Math.max(currentDiameter, currentHeight), diameter.get()));

        return currentHeight;
    }

}
