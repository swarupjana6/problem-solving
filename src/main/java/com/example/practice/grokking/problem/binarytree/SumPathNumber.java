package com.example.practice.grokking.problem.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SumPathNumber {

	public static void main(String[] args) {

		/*TreeNode<Integer> root = new TreeNode<>(1);
	    root.left = new TreeNode<>(0);
	    root.right = new TreeNode<>(1);
	    root.left.left = new TreeNode<>(1);
	    root.right.left = new TreeNode<>(6);
	    root.right.right = new TreeNode<>(5);
	    System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));*/
	    
	    
	    TreeNode<Integer> root1 = new TreeNode<>(1);
	    root1.left = new TreeNode<>(7);
	    root1.right = new TreeNode<Integer>(9);
	    root1.right.left = new TreeNode<Integer>(2);
	    root1.right.right = new TreeNode<Integer>(9);
	    System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root1));
	}

	private static Integer findSumOfPathNumbers(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		
		hasPath(root, currentPath, result);
		return result.stream().reduce(0, (a,b) -> a +b);
	}

	private static void hasPath(TreeNode<Integer> root, List<Integer> currentPath, List<Integer> result) {

		if(root == null) {
			return;
		}
		currentPath.add(root.value);
		
		if(root.left == null && root.right == null) {
			int count = currentPath.size();
			int number = 0;
			for (int index = 0; index < currentPath.size(); index++) {
				int currentNumber = currentPath.get(index);
				if(currentNumber > 0) {
					number += currentPath.get(index) * Math.pow(10, count - 1);
				}
				count--;
			}
			result.add(number);
		} else {
			hasPath(root.left, currentPath, result);
			hasPath(root.right, currentPath, result);
		}
		currentPath.remove(currentPath.size() - 1);
	}

}
