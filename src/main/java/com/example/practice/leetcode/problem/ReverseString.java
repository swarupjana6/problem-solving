package com.example.practice.leetcode.problem;

public class ReverseString {

	public static String reverseString(String s){
		
		char value[] = s.toCharArray();
		int n = s.length() - 1;
		int checkNo = (n -1) >> 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char temp = value[j];
            value[j] = value[k];
            value[k] = temp;
        }
        
		return new String(value);
	}
	public static void main(String[] args) {


		System.out.println(reverseString("swaru"));

	}

}
