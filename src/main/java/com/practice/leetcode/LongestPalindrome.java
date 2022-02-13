package com.practice.leetcode;

import java.util.Arrays;

public class LongestPalindrome {

	public static String longestPalindrome(String s) {

		char[] sArray = s.toCharArray();
		String result = "";
		if (sArray.length == 0 || sArray.length == 1) {
			return new String(sArray);
		}
		for (int windowStart = 0; windowStart < sArray.length; windowStart++) {
			String slideString = "";
			for (int windowEnd = windowStart; windowEnd < sArray.length; windowEnd++) {
				char[] slideWindow = Arrays.copyOfRange(sArray, windowStart, windowEnd + 1);
				if (!isReverse(slideWindow)) {
					continue;
				}
				slideString = new String(slideWindow);
			}
			if (result.length() < slideString.length()) {
				result = slideString;
			}
		}
		return result;
	}

	private static boolean isReverse(char[] s) {

		char[] reverseS = new char[s.length];
		System.arraycopy(s, 0, reverseS, 0, s.length);
		int n = s.length - 1;
		for (int i = (n - 1) >> 1; i >= 0; i--) {
			int k = n - i;
			char temp = reverseS[i];
			reverseS[i] = reverseS[k];
			reverseS[k] = temp;
		}

		return Arrays.equals(s, reverseS);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeV2("bababbabad"));

	}

	public static String longestPalindromeV2(String s) {
		String value = "";
        int size = 0;
        if(s != null && s.length() > 1 ) {
            char[] c = s.toCharArray();
            System.out.println("char c : - " + new String(c));
            for (int i = 0; i < c.length; i++) {
                for (int j = c.length - 1; j >= i; j--) {
                	char ci = c[i];
                	char cj = c[j];
                	System.out.println(String.format("{c[%d] = %c}, {c[%d] = %c}", i,ci,j,cj));
                    if (ci == cj && j - i + 1 > size) {
                        StringBuilder temp = new StringBuilder(s.substring(i, j + 1));
                        if (temp.toString().equals(temp.reverse().toString())) {
                            if (temp.toString().length() > size) {
                                value = temp.toString();
                                size = temp.toString().length();
                                System.err.println("new Value : - " + value);
                            }
                        }
                    }
                }
            }
        } else {
            value = s;
        }
        return value;
	}


}
