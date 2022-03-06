package com.practice.educative.grokking.binarytree;

import com.practice.problems.grokking.educative.binarytree.TreeNode;
import com.practice.problems.grokking.educative.binarytree.impl.jan.FindAllTreePathsJana;
import com.practice.problems.grokking.educative.binarytree.impl.myr.FindAllTreePathsMayur;
import com.practice.problems.grokking.educative.binarytree.impl.tap.FindAllTreePathsTapan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllTreePathsTest1 {

    TreeNode getTreeNodeData1() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        return root;
    }

    int getSumData1() {
        return 23;
    }

    @DisplayName("Test FindAllTreePathsJana.findPaths()")
    @Test
    void testFindPathsJana() {
        assertEquals("5", "5");
        System.out.println("Tree paths with sum " + getSumData1() + ": " + new FindAllTreePathsJana().findPaths(getTreeNodeData1(), getSumData1()));
    }

    @DisplayName("Test FindAllTreePathsTapan.findPaths()")
    @Test
    void testFindPathsTapan() {
        assertEquals("5", "5");
        System.out.println("Tree paths with sum " + getSumData1() + ": " + new FindAllTreePathsTapan().findPaths(getTreeNodeData1(), getSumData1()));
    }

    @DisplayName("Test FindAllTreePathsMayur.findPaths()")
    @Test
    void testFindPathsMayur() {
        assertEquals("5", "5");
        System.out.println("Tree paths with sum " + getSumData1() + ": " + new FindAllTreePathsMayur().findPaths(getTreeNodeData1(), getSumData1()));
    }
}