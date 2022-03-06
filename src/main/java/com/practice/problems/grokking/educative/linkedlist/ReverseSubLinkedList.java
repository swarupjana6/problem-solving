package com.practice.problems.grokking.educative.linkedlist;

/**
 * Given the head of a LinkedList and two positions �p� and �q�, reverse the
 * LinkedList from position �p� to �q�.
 * 
 * https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2
 * 
 * @author SKJ-PC
 *
 */
public class ReverseSubLinkedList {

	public static void main(String[] args) {

		ListNode<Integer> head = new ListNode<>(1);
		head.add(2);head.add(3);head.add(4);
		head.add(5);head.add(6);

		System.out.println("ListNode before reverse : - ");
		ListNode.print(head);
		ListNode<Integer> result = reverse(head, 2, 4);
		System.out.println("ListNode after reverse sublist: - ");
		ListNode.print(result);
	}

	public static <T> ListNode<T> reverse(ListNode<T> head, int p, int q) {
		ListNode<T> current = head;
		ListNode<T> subList = null;
		ListNode<T> next = null;
		ListNode<T> preLastNode = null;
		ListNode<T> lastNodeSublist = null;

		// Step 1 : Create a new List
		// Step 2 : Iterate till p-1
		// Step 3 : Reverse the sublist
		// Step 4 : Iterate from q+1 till end

		// Step 1 & 2
		ListNode<T> result = current;
		for (int i = 1; i <= p - 1; i++) {
			preLastNode = current;
			current = current.next;
		}

		// Step 3 Reverse Sublist from p to q
		subList = current;
		lastNodeSublist = current;

		for (int i = 1; i <= (q - p + 1); i++) {
			next = current.next;
			current.next = subList;
			subList = current;
			current = next;

			if (i == 1) {
				subList.next = null;
			}
		}

		if (preLastNode != null) {
			preLastNode.next = subList;
		} else {
			result = subList;
		}
		lastNodeSublist.next = current;

		return result;
	}

}
