package com.practice.problems.adityavermapractice.stack.impl.tap;

import com.practice.problems.adityavermapractice.stack.StockSpanProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblemTapan extends StockSpanProblem {

    @Override
    public List<Integer> stockSpan(List<Integer> stocks) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = 0; i < stocks.size(); i++) {
            int currentStock = stocks.get(i);

            if (indexStack.isEmpty()) outputList.add(1);
            else if (stocks.get(indexStack.peek()) > currentStock) outputList.add(1);
            else {
                while (!indexStack.isEmpty() && stocks.get(indexStack.peek()) <= currentStock)
                    indexStack.pop();

                outputList.add(!indexStack.isEmpty() ? i - indexStack.peek() : 1);
            }

            indexStack.add(i);
        }

        return outputList;
    }

    private List<Integer> stockSpan1(List<Integer> inputList) {
        List<Integer> outputIndex = new NearestGreaterToLeftTapan().nearestGreaterToLeft(inputList, -1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < outputIndex.size(); i++) {
            int index = outputIndex.get(i);
            // Consecutive smaller and before it
            result.add((index == -1) ? 1 : i - index);
        }
        return result;
    }
}
