package com.practice.problems.adityavermapractice.recursion.tap;

import com.practice.problems.adityavermapractice.recursion.Node;

import java.io.PrintStream;
import java.util.List;
import java.util.Stack;

import static com.practice.problems.adityavermapractice.recursion.tap.Utils.*;

public class RecursionProblemsGroupOneEasy {

    private static void template() {
        // BASE CONDITION

        // HYPOTHESIS

        // INDUCTION
    }

    public static void print1ToN(Integer num, PrintStream out) {
        // BASE CONDITION
        if (num == 0) return;

        // HYPOTHESIS
        print1ToN(num - 1, out);

        // INDUCTION
        out.print(num + " ");
    }

    public static void printNTo1(Integer num, PrintStream out) {
        // BASE CONDITION
        if (num == 0) return;

        // INDUCTION
        out.print(num + " ");

        // HYPOTHESIS
        print1ToN(num - 1, out);
    }

    public static int heightOfBinaryTree(Node node) {
        // BASE CONDITION
        if (node == null) return 0;

        // HYPOTHESIS
        int heightLeft = heightOfBinaryTree(node.left());
        int heightRight = heightOfBinaryTree(node.right());
        int maxHeight = Math.max(heightLeft, heightRight);

        // INDUCTION
        return maxHeight + 1;
    }

    public static void sortList(List<Integer> list) {
        // BASE CONDITION
        if (list.size() == 1) return;

        // HYPOTHESIS
        int lastElement = list.remove(list.size() - 1);
        sortList(list);

        // INDUCTION
        insertElementInSortedList(lastElement, list);
    }

    public static void sortStack(Stack<Integer> stack) {
        // BASE CONDITION
        if (stack.size() <= 1) return;

        // HYPOTHESIS
        Integer stackTop = stack.pop();
        sortStack(stack);

        // INDUCTION
        insertElementInSortedStack(stackTop, stack);
    }

    public static void deleteMiddleElement(Stack<Integer> stack, int deleteElementIndex) {
        // BASE CONDITION
        if (stack.size() == deleteElementIndex) {
            stack.pop();
            return;
        }

        // HYPOTHESIS
        int stackTop = stack.pop();
        deleteMiddleElement(stack, deleteElementIndex);

        // INDUCTION
        stack.push(stackTop);
    }

    public static void reverseStack(Stack<Integer> stack) {
        // BASE CONDITION
        if (stack.size() == 1) return;

        // HYPOTHESIS - Completely reversed stack
        int stackTop = stack.pop();
        reverseStack(stack);

        // INDUCTION
        insertToStacksBottom(stack, stackTop);
    }

    public static int kthSymbolGrammar(int n, int k) {
        // BASE CONDITION
        if (n == 1 && k == 1) return 0;

        // HYPOTHESIS and INDUCTION
        double mid = Math.pow(2, n - 1) / 2;
        if (k <= mid) return kthSymbolGrammar(n - 1, k);
        else return 1 - kthSymbolGrammar(n - 1, (int) (k - mid));
    }

    public static void towerOfHanoi(int n, Character source, Character destination, Character helper, Integer noOfSteps) {
        // BASE CONDITION
        if (n == 1) {
            movePlateFromSourceToDestination(n, source, destination);
            return;
        }

        // HYPOTHESIS
        towerOfHanoi(n - 1, source, helper, destination, noOfSteps + 1);

        // INDUCTION
        movePlateFromSourceToDestination(n, source, destination);
        towerOfHanoi(n - 1, helper, destination, source, noOfSteps + 1);
    }

    public static Integer josephusMethod(List<Integer> inputs, int k, int index) {
        // BASE CONDITION
        if (inputs.size() == 1) {
            return inputs.get(0);
        }

        // HYPOTHESIS
        index = (index + k) % inputs.size();
        inputs.remove(index);

        // INDUCTION
        return josephusMethod(inputs, k, index + 1);
    }
}
