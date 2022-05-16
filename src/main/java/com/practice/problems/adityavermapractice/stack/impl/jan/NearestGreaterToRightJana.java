package com.practice.problems.adityavermapractice.stack.impl.jan;

import com.practice.problems.adityavermapractice.stack.NearestGreaterToRight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRightJana extends NearestGreaterToRight {
    @Override
    public List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex) {
    	List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int index = inputList.size() - 1; index >= 0; index--) {
			if(stack.size() == 0) {
				result.add(-1);
			} else if(stack.size() > 0 && stack.peek() > inputList.get(index)) {
				result.add(stack.lastElement());
			} else if(stack.size() > 0 && stack.peek() <= inputList.get(index)) {
				while(stack.size() > 0 && stack.peek() <= inputList.get(index)) {
					stack.pop();
				}
				if(stack.size() == 0) {
					result.add(-1);
				} else {
					result.add(stack.peek());
				}
			}
			stack.push(inputList.get(index));
			
		}
		Collections.reverse(result);
		
		return result;
    }

    public static void main(String[] args) {
        new NearestGreaterToRightJana().execute();
    }
}
