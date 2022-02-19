package com.practice.educative.grokking.modifiedbinarysearch;

public class BinarySearch {

	public static int search(int[] arr, int key) {
		
		int start = 0;
		int end = arr.length - 1;
		int middle = end >> 1;
		
		int startPt = 0;
		int endPt = 0;
		
		boolean isAscending = arr[middle] > arr[middle - 1];
		
		if(arr[middle] == key) {
			return middle;
		}
		
		if (isAscending) { 
	        if (key < arr[middle]) {
	        	startPt = start	;
				endPt = middle + 1; 
	        } else { 
	        	startPt = middle + 1;
				endPt = end; 
	        }
	      } else {         
	        if (key > arr[middle]) {
	        	startPt = start	;
				endPt = middle + 1; 
	        } else {
	        	startPt = middle + 1;
				endPt = end;
	        	
	        }
	      }
		
		
		for(int index = startPt; index <= endPt; index++) {
			if(arr[index] == key) return index;
		}
		
	    return -1;
	  }

	  public static void main(String[] args) {
	    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
	    System.out.println(BinarySearch.search(new int[] { 4, 6, 9, 10 }, 4));
	    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
	    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
	    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
	  }

}
