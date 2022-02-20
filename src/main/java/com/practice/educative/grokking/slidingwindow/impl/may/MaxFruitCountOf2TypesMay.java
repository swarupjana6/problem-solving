package com.practice.educative.grokking.slidingwindow.impl.may;

import java.util.HashMap;
import java.util.Map;

import com.practice.educative.grokking.slidingwindow.MaxFruitCountOf2Types;

public class MaxFruitCountOf2TypesMay implements MaxFruitCountOf2Types {
    @Override
    public int findLength(char[] arr) {
		int windowStart = 0;
		int maxLength = 0;
		Map<Character, Integer> charCountMap = new HashMap();
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			charCountMap.put(arr[windowEnd], charCountMap.getOrDefault(arr[windowEnd], 0) + 1);
			while(charCountMap.size()>2) {
				char left=arr[windowStart];
				charCountMap.put(left, charCountMap.get(left)-1);
				if(charCountMap.get(left)==0)
					charCountMap.remove(left);
				windowStart++;
				
			}
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
			
		}
		return maxLength;

	}
}
