package com.practice.problems.adityavermapractice.stack.impl.tap;

import com.practice.problems.adityavermapractice.stack.NearestGreaterToRight;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRightTapan extends NearestGreaterToRight {

    @Override
    public List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = inputList.size() - 1; i >= 0; i--) {
            int currentElement = inputList.get(i);

            if (indexStack.empty()) outputList.add(pseudoIndex);
            else if (inputList.get(indexStack.peek()) > currentElement) outputList.add(indexStack.peek());
            else if (inputList.get(indexStack.peek()) <= currentElement) {

                while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) < currentElement) indexStack.pop();

                outputList.add(indexStack.isEmpty() ? pseudoIndex : indexStack.peek());
            }

            indexStack.push(i);
        }

        Collections.reverse(outputList);
        return outputList;
    }

    public static void main(String[] args) {
        new NearestGreaterToRightTapan().execute();
    }
}