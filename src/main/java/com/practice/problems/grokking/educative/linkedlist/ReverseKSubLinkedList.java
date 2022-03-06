package com.practice.problems.grokking.educative.linkedlist;

/**
 * Reverse every K-element Sub-list (medium)
 * 
 * https://www.educative.io/courses/grokking-the-coding-interview/RMZylvkGznR
 * 
 * @author SKJ-PC
 *
 */
public class ReverseKSubLinkedList<T> {

	public static <T> ListNode<T> reverseKSubList(ListNode<T> head, int k) {

		ListNode<T> current = head;
		ListNode<T> result = null;
		ListNode<T> next = null;
		ListNode<T> lastNodeOfResult = result;

		while (current != null) {
			ListNode<T> previous = null;
			for (int index = 0; index < k; index++) {
				if (current == null) {
					break;
				}
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			while (null != result && lastNodeOfResult.next != null) {
				lastNodeOfResult = lastNodeOfResult.next;
			}

			if (result == null) {
				result = previous;
				lastNodeOfResult = result;
			} else {
				lastNodeOfResult.next = previous;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		ListNode<Integer> head = new ListNode<>(1);
		head.add(2);head.add(3);head.add(4);
		head.add(5);head.add(6);head.add(7);
		head.add(8);

		System.out.println("ListNode before reverse : - ");
		ListNode.print(head);
		ListNode<Integer> result = reverseKSubList(head, 3);
		System.out.println("ListNode after reverse sublist: - ");
		ListNode.print(result);
	}

}
