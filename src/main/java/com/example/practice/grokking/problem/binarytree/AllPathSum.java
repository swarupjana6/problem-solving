package com.example.practice.grokking.problem.binarytree;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {
	
	public static void hasPath(TreeNode<Integer> node, Integer sum, List<Integer> currentPath, List<List<Integer>> result){
		
		if(node == null) {
			return;
		}
		currentPath.add(node.value);
		
		if(node.left == null && node.right == null && node.value == sum) {
			result.add(new ArrayList<>(currentPath));
		} else {
			hasPath(node.left, sum - node.value, currentPath, result);
			hasPath(node.right, sum - node.value, currentPath, result);
		}
		currentPath.remove(currentPath.size() - 1);
	}
	
	public static List<List<Integer>> findPath(TreeNode<Integer> node, Integer sum){
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		
		hasPath(node, sum, currentPath, result);
		return result;
	}
	

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<>(12);
	    root.left = new TreeNode<>(7);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(4);
	    root.right.left = new TreeNode<>(10);
	    root.right.right = new TreeNode<>(5);
	    int sum = 23;
	    List<List<Integer>> result = findPath(root, sum);
	    System.out.println("Tree paths with sum " + sum + ": " + result);
	}

}
