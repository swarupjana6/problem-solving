package com.practice.problems.adityaverma.tree;

import com.practice.problems.adityaverma.tree.parent.Node;
import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTree2;
import static com.practice.problems.adityaverma.tree.parent.GenericTree.getSampleTreeSymmetric;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class TreeSymmetric {

    public static void main(String[] args) {
        //print(getSampleTree1(), getSampleTree1(), lca -> assertEquals(false, lca));
        TreesMirror.print(getSampleTreeSymmetric(), getSampleTreeSymmetric(), lca -> assertEquals(true, lca));
        TreesMirror.print(getSampleTree2(), getSampleTree2(), lca -> assertEquals(false, lca));
    }

    private static boolean isSymmetric(Node<Integer> first, Node<Integer> second) {
        int firstSize = first.children().size();
        int secondSize = second.children().size();
        if (firstSize != secondSize) return false;

        for (int index = 0; index < firstSize / 2; index++) {
            int mirrorIndex = secondSize - 1 - index;
            Node<Integer> firstsChild = first.children().get(index);
            Node<Integer> secondsChild = second.children().get(mirrorIndex);
            if (isSymmetric(firstsChild, secondsChild) == false) return false;
        }

        return true;
    }

}
