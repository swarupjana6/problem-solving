package com.practice.educative.grokking.binarytree.impl.jan;

import com.practice.educative.grokking.binarytree.FindAllTreePaths;
import com.practice.educative.grokking.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePathsJana implements FindAllTreePaths {

    private void hasPath(TreeNode<Integer> root, int sum, List<Integer> currentNodes, List<List<Integer>> allPaths) {

        if (root == null) {
            return;
        }
        currentNodes.add(root.value);

        if (root.left == null && root.right == null && root.value == sum) {
            allPaths.add(new ArrayList<>(currentNodes));
        } else {
            hasPath(root.left, sum - root.value, currentNodes, allPaths);
            hasPath(root.right, sum - root.value, currentNodes, allPaths);
        }
        currentNodes.remove(currentNodes.size() - 1);
    }

    @Override
    public List<List<Integer>> findPaths(TreeNode<Integer> node, Integer sum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        hasPath(node, sum, currentPath, result);
        return result;
    }
}
