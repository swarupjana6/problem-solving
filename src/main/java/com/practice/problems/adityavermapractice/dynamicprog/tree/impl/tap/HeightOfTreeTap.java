package com.practice.problems.adityavermapractice.dynamicprog.tree.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.tree.HeightOfTree;
import com.practice.problems.adityavermapractice.dynamicprog.tree.TreeNode;

public class HeightOfTreeTap extends HeightOfTree {

    @Override
    public Integer height(TreeNode<Integer> root) {
        /* BASE CONDITION */
        if (root == null) return 0;

        /* HYPOTHESIS */
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        /* INDUCTION */
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
