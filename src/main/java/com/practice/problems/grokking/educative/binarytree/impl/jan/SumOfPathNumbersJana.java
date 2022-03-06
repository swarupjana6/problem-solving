package com.practice.problems.grokking.educative.binarytree.impl.jan;

import com.practice.problems.grokking.educative.binarytree.SumOfPathNumbers;
import com.practice.problems.grokking.educative.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbersJana extends SumOfPathNumbers {
    @Override
    public Integer findSumOfPathNumbers(TreeNode<Integer> root) {
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
