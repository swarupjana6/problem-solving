package com.practice.educative.grokking.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * @author swjana
 *
 */
public class AddTwoNumberLinkedList {
	
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        
        ListNode<Integer> result = new ListNode<Integer>(0);
        result.value = 0;
        int reminder = 0;
        
        ListNode<Integer> current = result;
        while(true){        
        	if(l1 != null){
        		current.value += l1.value;
        	}
        	if(l2 != null){
        		current.value += l2.value;
        	}
        	current.value += reminder;
            reminder = 0;
            
            if(current.value > 9) {
                reminder = current.value/10;
                current.value = current.value % 10;
            }
        	l1 = (l1 != null)?l1.next:null;
            l2 = (l2 != null)?l2.next:null;
            
            if(l1 != null || l2 != null){
                current.next = new ListNode<>(0);
                current = current.next;
            } else {
            	break;
            }
            
        }
        
        if(reminder > 0 ){
        	current.next = new ListNode<>(0);
        	current.next.value = reminder;
        }
        
        return result;
    }

	public static void main(String[] args) {
		
		ListNode<Integer> l1 = new ListNode<>(9);
		l1.add(9);l1.add(9);l1.add(9);l1.add(9);
		l1.add(9);l1.add(9); 
		ListNode<Integer> l2 = new ListNode<>(9);
		l2.add(9);l2.add(9);l2.add(9);
		
		ListNode<Integer> result = addTwoNumbers(l1, l2);
		ListNode.print(result);
	}

}
