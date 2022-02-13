package com.example.practice.grokking.problem.linkedlist;

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
	
	public void addLeftNode(TreeNode<T> node) {
		this.left = node;
	}
	
	public void addRightNode(TreeNode<T> node) {
		this.right = node;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

	
}
