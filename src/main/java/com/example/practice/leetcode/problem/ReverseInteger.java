package com.example.practice.leetcode.problem;

public class ReverseInteger {

	public static int reverse(int x) {

		long result = 0;
		boolean isNegative = false;
		
		
		if(x < 0){
			x *= -1;
			isNegative = true;
		}
		while (x > 0) {
			result = (10 * result) +  x % 10;
			x /= 10;
		}
		
		result = isNegative? - result:result;
		
		if((result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)){
			return 0;
		}
		
		return (int)result;
	}

	public static void main(String[] args) {


		System.out.println(reverse(1534236461));

	}

}
