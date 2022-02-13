package com.example.practice.grokking.problem.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageBinaryTree {

	public static List<Double> findLevelAverages(TreeNode<Integer> root) {
		List<Double> result = new ArrayList<>();

		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			double value = 0.0;
			for (int index = 0; index < levelSize; index++) {
				TreeNode<Integer> currentNode = queue.poll();
				value += (double)currentNode.value;
				
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(value/levelSize);
		}

		return result;
	}
	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<>(12);
	    root.left = new TreeNode<>(7);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(9);
	    root.left.right = new TreeNode<>(2);
	    root.right.left = new TreeNode<>(10);
	    root.right.right = new TreeNode<>(5);
	    List<Double> result = findLevelAverages(root);
	    System.out.print("Level averages are: " + result);
	}

}
