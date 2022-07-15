package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ReverseLinkedList;
import com.practice.problems.grokking.educative.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedListTap extends ReverseLinkedList {
    @Override
    protected ListNode reverse(ListNode head) {
        //return method1(head);
        return method2(head);
    }

    private ListNode method1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        head = dummy;
        while (!stack.isEmpty()) {
            ListNode current = stack.pop();
            head.next = new ListNode(current.value);
            head = head.next;
        }

        return dummy.next;
    }

    private ListNode method2(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
