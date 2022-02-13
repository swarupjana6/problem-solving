package com.practice.leetcode;

public class IntegerPalindrome {

	public static boolean isPalindrome(int x) {
		
		int number = x;
		int result = 0;
		if(x<0) {
			return false;
		}
		while (x > 0) {
			result = (10 * result) +  x % 10;
			x /= 10;
		}
		
		return number==result;
	}
	
	public static void main(String[] args) {

		System.out.println("Number is palindrome : - " + isPalindrome(-121));
	}

}
