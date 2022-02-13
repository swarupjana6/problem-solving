package com.practice.educative.grokking.binarytree;

public class DFTSumOfPaths {

	public static double findSumOfPathNumbers(TreeNode<Integer> root) {
		Integer sum = 0, currentPathNo = 0;
		return findSumRecursive(root, sum, currentPathNo);
	}

	private static int findSumRecursive(TreeNode<Integer> currentNode, Integer sum, int currentPathNo) {
		if (currentNode == null) return sum;

		// if the current node is a leaf and its value is equal to sum, save the
		// current path
		currentPathNo = currentPathNo*10 + currentNode.value;
		if (currentNode.left == null && currentNode.right == null) {
			sum = sum + currentPathNo;
		} else {
			sum = findSumRecursive(currentNode.left, sum, currentPathNo) + findSumRecursive(currentNode.right, sum, currentPathNo);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(0);
		root.right = new TreeNode<>(1);
		root.left.left = new TreeNode<>(1);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(5);
		System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
		
		TreeNode<Integer> root1 = new TreeNode<>(1);
	    root1.left = new TreeNode<>(7);
	    root1.right = new TreeNode<Integer>(9);
	    root1.right.left = new TreeNode<Integer>(2);
	    root1.right.right = new TreeNode<Integer>(9);
	    System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root1));
	}
}
