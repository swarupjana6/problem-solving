package com.practice.problems.grokking.educative.binarytree;

import com.practice.problems.grokking.educative.binarytree.impl.jan.SumOfPathNumbersJana;

public abstract class SumOfPathNumbers {

	public abstract Integer findSumOfPathNumbers(TreeNode<Integer> root);

	public static void main(String[] args) {

		/*TreeNode<Integer> root = new TreeNode<>(1);
	    root.left = new TreeNode<>(0);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(1);
	    root.right.left = new TreeNode<>(6);
	    root.right.right = new TreeNode<>(5);
	    System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));*/
	    
	    
	    TreeNode<Integer> root1 = new TreeNode<>(1);
	    root1.left = new TreeNode<>(7);
	    root1.right = new TreeNode<Integer>(9);
	    root1.right.left = new TreeNode<Integer>(2);
	    root1.right.right = new TreeNode<Integer>(9);

		System.out.println("Total Sum of Path Numbers: " + new SumOfPathNumbersJana().findSumOfPathNumbers(root1));
	}
}
