package com.zhandev.algorithm;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5,8,6,9,2,1,3,4,7,0};
		bubbleSort(arr);
		System.out.println("bubble sort: " + Arrays.toString(arr));
		
		int[] arr2 = {5,8,6,9,2,1,3,4,7,0};
		bubbleSortOptimized(arr2);
		System.out.println("optimized bubble sort: " + Arrays.toString(arr2));
	}

	public static void bubbleSort(int[] array) {
		boolean isSorted = false; 
		
		while (!isSorted) {
			isSorted = true; 
			for (int i = 0; i < array.length -1; i++) {
				if (array[i] > array[i+1]) {
					swap(array, i, i+1);
					isSorted = false;
				}
			}
		}
	}
	
	public static void bubbleSortOptimized(int[] array) {
		boolean isSorted = false; 
		int lastUnsorted = array.length -1;
		while (!isSorted) {
			isSorted = true; 
			for (int i = 0; i < lastUnsorted; i++) {
				if (array[i] > array[i+1]) {
					swap(array, i, i+1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}
	
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i]; 
		array[i] = array[j];
		array[j] = temp;
	}
}
