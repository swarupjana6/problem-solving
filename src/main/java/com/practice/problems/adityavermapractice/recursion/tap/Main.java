package com.practice.problems.adityavermapractice.recursion.tap;

import com.practice.problems.adityavermapractice.recursion.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.practice.problems.adityavermapractice.recursion.tap.RecursionProblemsGroupOneEasy.*;
import static com.practice.problems.adityavermapractice.recursion.tap.SubsetMethodEasyMedium.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        //groupOne();
        groupSubsetMethod();
    }

    private static void groupOne() {
        print1ToN(5, out);
        out.println("------------");
        printNTo1(5, out);
        out.println("------------");
        executeHeightOfBinaryTree();
        out.println("------------");
        executeSortAList();
        out.println("------------");
        executeSortStack();
        out.println("------------");
        executeDeleteMiddleElement();
        out.println("------------");
        executeReverseStack();
        out.println("------------");
        executeKthGrammarSymbol();
        out.println("------------");
        executeTowerOfHanoi();
    }

    private static void executeTowerOfHanoi() {
        towerOfHanoi(3, 'S', 'D', 'H', 0);
    }

    private static void executeKthGrammarSymbol() {
        out.println(kthSymbolGrammar(1, 1));
        out.println(kthSymbolGrammar(2, 2));
        out.println(kthSymbolGrammar(3, 3));
        out.println(kthSymbolGrammar(3, 4));
    }

    private static void groupSubsetMethod() {
        //executeSubset();
        out.println("------------");
        //executeSubsets();
        out.println("------------");
        //executePermutationWithSpaces();
        out.println("------------");
        //executeLetterCaseChange();
        out.println("------------");
        //executeBalancedParentheses();
        out.println("------------");
        //executeNoOf1sAnd0s();
        out.println("------------");
        executeJosephusMethod();
        out.println("------------");
    }

    private static void executeJosephusMethod() {
        List<Integer> inputs = IntStream.rangeClosed(1, 40).mapToObj(i -> i).collect(Collectors.toList());
        int k = 7;
        out.println(josephusMethod(inputs, k - 1, 0));
    }

    private static void executeSubset() {
        List<String> outputs = new ArrayList<>();
        subset("ab", "", outputs);
        out.println(outputs);
    }

    private static void executeNoOf1sAnd0s() {
        List<String> outputs = new ArrayList<>();
        noOf1sAnd0s("", outputs, 5, 0, 0);
        out.println(outputs);
    }

    private static void executeBalancedParentheses() {
        List<String> outputs = new ArrayList<>();
        balancedParentheses("", outputs, 3, 3);
        out.println(outputs);
    }

    private static void executeLetterCaseChange() {
        List<String> outputs = new ArrayList<>();
        letterCaseChange("ab", "", outputs);
        out.println(outputs);
    }

    private static void executeSubsets() {
        Set<String> outputs = new HashSet<>();
        uniqueSubset("ab", "", outputs);
        out.println(outputs);
    }

    private static void executePermutationWithSpaces() {
        Set<String> outputs = new HashSet<>();
        permutationWithSpaces("abc", "", outputs);
        out.println(outputs);
    }

    private static void executeSortAList() {
        sortList(new ArrayList<>(List.of(2, 6, 1, 3)));
    }

    private static void executeHeightOfBinaryTree() {
        heightOfBinaryTree(getNode1());
    }

    private static void executeReverseStack() {
        Stack<Integer> stack = new Stack<>();
        List.of(1, 2, 3, 4, 5).forEach(element -> stack.add(element));
        reverseStack(stack);
        out.println(stack);
    }

    private static void executeDeleteMiddleElement() {
        Stack<Integer> stack = new Stack<>();
        List.of(1, 2, 3, 4, 5).forEach(element -> stack.add(element));
        Integer stackSize = (stack.size() / 2) + 1;
        deleteMiddleElement(stack, stackSize);
    }

    private static void executeSortStack() {
        Stack<Integer> stack = new Stack<>();
        List.of(3, 5, 1, 2, 4).forEach(element -> stack.add(element));
        sortStack(stack);
        out.println(stack);
    }

    private static Node getNode1() {
        Node node311 = new Node(1, null, null);
        Node node312 = new Node(3, null, null);
        Node node321 = new Node(11, null, null);
        Node node322 = new Node(13, null, null);

        Node node21 = new Node(2, node311, node312);
        Node node22 = new Node(12, node321, node322);

        Node node1 = new Node(10, node21, node22);

        return node1;
    }
}
