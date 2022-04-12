package com.practice.problems.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScrollingNumber {

	public static void findCombinations(int a, int b) {

		boolean isFound = false;
		for (int c = a; c <= b; c++) {
			final Set<Integer> set = new HashSet<Integer>();
			final Map<Integer, Integer> map = new HashMap<>();
			final String number = String.valueOf(c);
			if (number.contains("0")) {
				continue;
			}
			for (int i = 0; i < number.length(); i++) {
				final int digit = number.charAt(i);
				set.add(digit);
				map.put(digit, i);
			}
			if (number.toCharArray().length != set.size()) {
				continue;
			}

			final int length = number.length();
			int j = 0;
			int k = 1;
			while (k <= length) {
				set.remove((int) number.charAt(j));
				System.out.println("number.charAt(j) = " + number.charAt(j));
				System.out.println("map.get((int) number.charAt(j)) = " + map.get((int) number.charAt(j)));
				System.out.println("number.charAt(j) + map.get((int) number.charAt(j)) = " + number.charAt(j) + map.get((int) number.charAt(j)));
				j = (number.charAt(j) + map.get((int) number.charAt(j))) % length;
				k++;
			}
			if (j == 0 && set.size() == 0) {
				System.out.println(number);
				isFound = true;
			}

		}
		if (!isFound) {
			System.out.println(-1);
		}

	}
	
	public static void main(String[] args) {
		findCombinations(100, 500);
	}
}
