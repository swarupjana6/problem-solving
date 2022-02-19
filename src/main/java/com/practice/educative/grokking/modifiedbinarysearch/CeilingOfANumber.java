package com.practice.educative.grokking.modifiedbinarysearch;

public class CeilingOfANumber {

	public static int searchCeilingOfANumber(int[] arr, int key) {
		
		int start = 0;
		int end = arr.length - 1;
		int middle = (start + end)/2;
		
		int startPt = 0;
		int endPt = 0;
		
		boolean isLeft = false;
		
		if(key < arr[0]) {
			return 0;
		}
		
//		if(arr[middle] >= key) {
//			return middle;
//		}
		
		if(arr[middle] < key) {
			startPt = middle + 1;
			endPt = end;
			isLeft = true;
		} else {
			startPt = start	;
			endPt = middle + 1;
		}
		
		for(int index = startPt; index <= endPt; index++) {

			if(index == endPt)
				return (key == arr[index]) ? index : -1;
			int firstNode = arr[index];
			int secondNode = (isLeft) ? arr[index+1]:arr[index-1];
//			int secondNode = arr[index+1];
			
			if(firstNode == key)
				return index;
			
			if((firstNode < secondNode) && (firstNode <= arr[index] || secondNode >= arr[index])) {
				return index;
			} else if ((firstNode >= arr[index] || secondNode <= arr[index])){
				return index + 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 2, 4, 6, 10, 12, 14 }, 3));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10, 12 }, 7));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
//		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
//		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	}

}
