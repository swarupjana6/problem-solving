package com.example.practice.grokking.problem.binarytree;

public class BinaryTreePathSum {
	
	public static boolean hasPath(TreeNode<Integer> node, Integer sum) {
		
		if(node == null) {
			return false;
		}
		
		if(node.left == null && node.right == null && node.value == sum) {
			return true;
		}
		
		return hasPath(node.left, sum - node.value) || hasPath(node.right, sum - node.value);
	}

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<>(12);
	    root.left = new TreeNode<>(7);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(9);
	    root.right.left = new TreeNode<>(10);
	    root.right.right = new TreeNode<>(5);
	    System.out.println("Tree has path: " + hasPath(root, 23));
	    System.out.println("Tree has path: " + hasPath(root, 16));
	}

}
