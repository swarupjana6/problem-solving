package com.practice.educative.grokking.linkedlist;

import java.util.List;

public class BinaryTreeTraversal {

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<>(12);
	    root.left = new TreeNode<>(7);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(9);
	    root.right.left = new TreeNode<>(10);
	    root.right.right = new TreeNode<>(5);
	    
	    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
	    
	    System.out.println(result);
	}
	

}
