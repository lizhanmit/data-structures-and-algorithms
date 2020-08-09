package com.zhandev.algorithm.sort;

public class ShellSort {

	public void shellSort(int[] arr) {
		if (arr == null || arr.length <= 1) return;

		int gap = 1;
		while (gap < arr.length) {
			gap = gap * 3 + 1;
		}
		
		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int valueToInsert = arr[i];
				int j = i - gap;
				for (; j >= 0; j = j - gap) {
					if (arr[j] > valueToInsert) {
						arr[j + gap] = arr[j];
					} else {
						break;
					}
				}
				arr[j + gap] = valueToInsert;
			}
			
			gap = gap / 3;
		}
	}
}
