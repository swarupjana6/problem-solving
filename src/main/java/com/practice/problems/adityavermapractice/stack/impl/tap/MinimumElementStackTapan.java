package com.practice.problems.adityavermapractice.stack.impl.tap;

import com.practice.problems.adityavermapractice.stack.MinimumElementStack;

import java.util.Stack;

public class MinimumElementStackTapan extends MinimumElementStack {

    private Stack<Integer> stack = new Stack<>();

    private Integer minimum = null;

    @Override
    public void push(Integer element) {
        if (minimum == null) {
            minimum = element;
            stack.push(element);
        } else if (element >= minimum) {
            stack.push(element);
        } else if (element < minimum) {
            Integer calculated = calculate(element);
            stack.push(calculated);
            minimum = element;
        }
    }

    @Override
    public Integer pop() {
        if (stack.peek() < minimum)
            return reverse(stack.peek());
        else
            return stack.peek();
    }

    @Override
    public Integer min() {
        return minimum;
    }

    @Override
    public Integer peek() {
        return stack.peek();
    }

    private Integer calculate(Integer element) {
        return (2 * element) - minimum;
    }

    private Integer reverse(Integer element) {
        return (2 * minimum) - element;
    }
}
