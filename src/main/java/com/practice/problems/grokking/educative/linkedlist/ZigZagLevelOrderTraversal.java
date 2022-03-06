package com.practice.problems.grokking.educative.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal<T> {

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(12);
	    root.left = new TreeNode<>(7);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(9);
	    root.right.left = new TreeNode<>(10);
	    root.right.right = new TreeNode<>(5);
	    root.right.left.left = new TreeNode<>(20);
	    root.right.left.right = new TreeNode<>(17);
		System.out.println("Before operation : - " + LevelOrderTraversal.traverse(root));
		List<List<Integer>> result = zigZagLevelOrder(root);
		System.out.println("Zig Zag Result: " + result);
	}

	public static <T> List<List<T>> zigZagLevelOrder(TreeNode<T> root) {
		List<List<T>> result = new ArrayList<List<T>>();

		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int levelOrderSize = queue.size();
			List<T> currentLevel = new ArrayList<T>(levelOrderSize);
			for (int i = 0; i < levelOrderSize; i++) {
				TreeNode<T> currentNode = queue.poll();
				if(count % 2 > 0) {
					currentLevel.add(0, currentNode.value);
				} else {
					currentLevel.add(currentNode.value);
				}
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentLevel);
			count++;
		}
		return result;
	}

}
