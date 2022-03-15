package com.practice.problems.adityaverma.stack;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Stack;

@Log4j2
public class MinimumStack {

    public static void main(String[] args) {
        List<Integer> input1 = List.of(10, 20, 30, 15, 5, 40);
        List<Integer> input2 = List.of(10, 10, 10, 10);

        List<Integer> input = input1;

        log.info("======= StackWithExtraSpace ============");
        MinStack stackWithExtraSpace1 = toStack(input, new StackWithExtraSpace());
        log.info(" min :: {}", stackWithExtraSpace1.min());
        log.info(" pop :: {}", stackWithExtraSpace1.pop());
        log.info(" min :: {}", stackWithExtraSpace1.min());

        log.info("======= StackWithoutExtraSpace ============");
        MinStack stackWithoutExtraSpace1 = toStack(input, new StackWithoutExtraSpace());
        log.info(" min :: {}", stackWithoutExtraSpace1.min());
        log.info(" pop :: {}", stackWithoutExtraSpace1.pop());
        log.info(" min :: {}", stackWithoutExtraSpace1.min());
    }

    private static MinStack toStack(List<Integer> list, MinStack stack) {
        list.forEach(element -> stack.push(element));
        return stack;
    }

    interface MinStack {
        void push(Integer element);

        Integer pop();

        Integer peek();

        Integer min();
    }

    static class StackWithExtraSpace implements MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        @Override
        public void push(Integer element) {
            if (minStack.isEmpty()) minStack.push(element);
            else if (element < minStack.peek()) minStack.push(element);

            stack.push(element);
        }

        @Override
        public Integer pop() {
            Integer element = stack.pop();

            Integer top = stack.peek();
            if (top < minStack.peek()) minStack.pop();

            return element;
        }

        @Override
        public Integer peek() {
            return stack.peek();
        }

        @Override
        public Integer min() {
            return minStack.peek();
        }
    }

    static class StackWithoutExtraSpace implements MinStack {

        Stack<Integer> stack = new Stack<>();
        Integer minimum = null;

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
        public Integer peek() {
            return stack.peek();
        }

        @Override
        public Integer min() {
            return minimum;
        }

        private Integer calculate(Integer element) {
            return (2 * element) - minimum;
        }

        private Integer reverse(Integer element) {
            return (2 * minimum) - element;
        }
    }
}
