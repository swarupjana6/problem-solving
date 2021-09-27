package com.example.practice.grokking.problem.linkedlist;

public class ListNode<T> {

	public T value;
	public ListNode<T> next;

	public ListNode(T value) {
		this.value = value;
	}

	public ListNode(T value, ListNode<T> next) {
		this.value = value;
		this.next = next;
	}
	
	public int size() {
		int count = 0;
		ListNode<T> head = this;
		while(head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
	
	public void add(T e) {
		ListNode<T> head = this;
		while(head.next != null) {
			head = head.next;
		}
		head.next = new ListNode<>(e);
	}
	
	public T remove(T e) {
		ListNode<T> head = this;
		T removeValue = null;
		
		if(head !=null && head.value == e) {
			removeValue = head.value;
			head = new ListNode<>(head.value, head.next);
		} else {
			while(head.next != null) {
				if(head.next.value == e) {
					removeValue = head.next.value;
					head.next = head.next.next;
					break;
				}
				head = head.next;
			}
		}
		return removeValue;
	}
	
	public static <T> void print(ListNode<T> head) {
		
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
}
