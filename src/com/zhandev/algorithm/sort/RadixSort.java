package com.zhandev.algorithm.sort;

import java.util.ArrayList;

public class RadixSort {

	public void radixSort(int[] arr) {
		if (arr == null || arr.length <= 1) return;
		
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			bucketList.add(new ArrayList<>());
		}
		
		int digit = 0;
		
		int max = arr[0];
		for (int a : arr) {
			if (a > max) {
				max = a;
			}
		}
		
		while (true) {
			int radix = (int) Math.pow(10, digit);
			
			if (max < radix) {
				break;
			}
			
			for (int a : arr) {
				bucketList.get(a / radix % 10).add(a);
			}
			
			int index = 0;
			for (ArrayList<Integer> bucket : bucketList) {
				for (Integer element : bucket) {
					arr[index++] = element;
				}
				bucket.clear();
			}
			
			digit++;
		}
	}
}
