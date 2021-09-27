package com.example.practice.grokking.problem.linkedlist;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList. 
 * Write a function to return the new head of the reversed LinkedList.
 * 
 * https://www.educative.io/courses/grokking-the-coding-interview/3wENz1N4WW9
 * 
 * @author SKJ-PC
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {

		ListNode<Integer> head = new ListNode<>(13);
		head.add(1);head.add(2);head.add(3);head.add(4);
		System.out.println("remove : - " + head.remove(13));

		System.out.println("ListNode before reverse : - ");
		ListNode.print(head);
		ListNode<Integer> result = reverseLinkedList(head);
		System.out.println("ListNode after reverse : - ");
		ListNode.print(result);
		
		System.out.println(result.size());
		

	}

	public static <T> ListNode<T> reverseLinkedList(ListNode<T> head) {

		ListNode<T> current = head;
		ListNode<T> previous = null;
		ListNode<T> next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}
}


