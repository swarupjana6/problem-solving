package com.practice.problems.grokking.educative.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Start by pushing the root node to the queue. Keep iterating until the queue
 * is empty. In each iteration, first count the elements in the queue (let�s
 * call it levelSize). We will have these many nodes in the current level. Next,
 * remove levelSize nodes from the queue and push their value in an array to
 * represent the current level. After removing each node from the queue, insert
 * both of its children into the queue. If the queue is not empty, repeat from
 * step 3 for the next level.
 * 
 * @author SKJ-PC
 *
 * @param <T>
 */
public class LevelOrderTraversal<T> {

	public static <T> List<List<T>> traverse(TreeNode<T> root) {
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
			result.add(currentLevel);
		}

		return result;
	}
}
