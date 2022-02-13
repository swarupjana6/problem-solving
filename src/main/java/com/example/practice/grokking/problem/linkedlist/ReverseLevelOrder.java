package com.example.practice.grokking.problem.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrder {

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<>(12);
		root.left = new TreeNode<>(7);
		root.right = new TreeNode<>(1);
		root.left.left = new TreeNode<>(9);
		root.right.left = new TreeNode<>(10);
		root.right.right = new TreeNode<>(5);
		System.out.println("Before operation : - " + LevelOrderTraversal.traverse(root));
		List<List<Integer>> result = reverseLevelOrder(root);
		System.out.println("Reverse level order traversal: " + result);
	}

	public static <T> List<List<T>> reverseLevelOrder(TreeNode<T> root) {
		List<List<T>> result = new ArrayList<List<T>>();

		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<T> currentLevel = new ArrayList<T>(levelSize);
			for (int index = 0; index < levelSize; index++) {
				TreeNode<T> currentNode = queue.poll();
				currentLevel.add(currentNode.value);

				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(0, currentLevel);
		}

		return result;
	}
}
