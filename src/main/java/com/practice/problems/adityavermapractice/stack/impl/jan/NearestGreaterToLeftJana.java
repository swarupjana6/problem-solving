package com.practice.problems.adityavermapractice.stack.impl.jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.practice.problems.adityavermapractice.stack.NearestGreaterToLeft;

public class NearestGreaterToLeftJana extends NearestGreaterToLeft {

	public static void main(String[] args) {

		new NearestGreaterToLeftJana().execute();
	}

	@Override
	public List<Integer> nearestGreaterToLeft(List<Integer> inputList, int pseudoIndex) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for (int index = 0; index < inputList.size(); index++) {
			if (stack.size() == 0) {
				result.add(-1);
			} else if (stack.size() > 0 && stack.peek() > inputList.get(index)) {
				result.add(stack.peek());
			} else if (stack.size() > 0 && stack.peek() <= inputList.get(index)) {
				while (stack.size() > 0 && stack.peek() <= inputList.get(index)) {
					stack.pop();
				}
				if (stack.size() == 0) {
					result.add(-1);
				} else {
					result.add(stack.peek());
				}
			}
			stack.push(inputList.get(index));

		}
		return result;
	}

}
