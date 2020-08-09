package com.zhandev.algorithm.sort;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		if (arr == null || arr.length <= 1) return;
		
		// i starts from 1, does not need to start from 0
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] > arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}
	
	// maybe better
	public void insertionSort2(int[] arr) {
		if (arr == null || arr.length <= 1) return;
		
		for (int i = 1; i < arr.length; i++) {
			int valueToInsert = arr[i];
			
			int j = i - 1;
			for (; j >= 0; j--) {
				if (arr[j] > valueToInsert) {
					arr[j + 1] = arr[j]; // use the value of j to overwrite the value of j+1
				} else {
					break;
				}
			}
			// this line must be placed out of the inner for loop,
			// because it is possible that all values before the valueToInsert are less than valueToInsert 
			arr[j + 1] = valueToInsert;
		}
	}
}
