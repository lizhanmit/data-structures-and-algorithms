package com.hackernoon.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * How do you find all pairs of an integer array whose sum is equal to a given number?
 * (Two sum)
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 5, 7, -1, 5};
		for (int[] pair : indicesOfPairs(nums, 6)) {
			System.out.println("(" + pair[0] + ", " + pair[1] + ")");
		}
	}

	
	public static List<int[]> indicesOfPairs(int[] nums, int target) {
		List<int[]> result = new ArrayList<>();
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				result.add(new int[] {i, map.get(complement)});
			}
			
			map.put(nums[i], i);
		}
		
		return result;
		
	}
	
}
