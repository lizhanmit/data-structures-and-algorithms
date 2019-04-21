package book.DSAInJava.sorting;

import java.util.Arrays;

public class ArraySorting {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 4, 2};
		insertionSort(arr);
		System.out.println("insertionSort: " + Arrays.toString(arr));
	}
	
	public static void insertionSort(int[] data) {
		int n = data.length;
		// k: the index of the element that is going to be sorted
		// as the first element does not need to be sorted, k starts from 1 instead of 0
		for (int k = 1; k < n; k++) {
			// cur: current element
			int cur = data[k];
			// j: the index that the current element will be inserted
			int j = k;
			while (j > 0 && data[j-1] > cur) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = cur;
		}
			
	}
}
