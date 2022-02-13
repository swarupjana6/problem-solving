package com.example.practice.grokking.problem.binarytree;

public class TreeNode<T> {

	T value;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode() {
	}

	public TreeNode(T value) {
		this.value = value;
	}

	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	
}
