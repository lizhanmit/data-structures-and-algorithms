package com.zhandev.algorithm.sort;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		if (arr == null || arr.length <= 1) return;
		
		for (int i = 0; i < arr.length; i++) {
			// suppose i is the min index
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = arr[minIndex];
			arr[minIndex] = arr[i]; 
			arr[i] = temp;
		}
	}
}
