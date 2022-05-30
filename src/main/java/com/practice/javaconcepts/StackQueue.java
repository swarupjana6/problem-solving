package com.practice.javaconcepts;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueue {

    public static void main(String[] args) {
        System.out.println("---ArrayDeque behaving as STACK---");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("POP from stack -> " + stack.pop());
        System.out.println("PEEK from stack -> " + stack.peek());

        System.out.println("---ArrayDeque behaving as QUEUE---");
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("POLL/REMOVE from queue -> " + queue.poll());
        System.out.println("PEEK from queue -> " + queue.peek());
    }
}
