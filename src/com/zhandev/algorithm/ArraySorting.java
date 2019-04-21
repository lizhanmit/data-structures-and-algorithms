package com.zhandev.algorithm;
import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 4, 2 };
		quickSort(arr);
		System.out.println("quickSort: " + Arrays.toString(arr));

		int[] arr2 = { 5, 3, 1, 4, 2 };
		insertSort(arr2);
		System.out.println("insertSort: " + Arrays.toString(arr2));

		int[] arr3 = { 5, 3, 1, 4, 2 };
		bubbleSort(arr3);
		System.out.println("bubbleSort: " + Arrays.toString(arr3));

		int[] arr4 = { 5, 3, 1, 4, 2 };
		bubbleSortOptimized(arr4);
		System.out.println("bubbleSortOptimized: " + Arrays.toString(arr4));

		int[] arr5 = { 5, 3, 1, 4, 2 };
		selectionSort(arr5);
		System.out.println("selectionSort: " + Arrays.toString(arr5));

		int[] arr6 = { 5, 3, 1, 4, 2 };
		shellSort(arr6);
		System.out.println("shellSort: " + Arrays.toString(arr6));

		int[] arr7 = { 5, 3, 1, 4, 2 };
		heapSort(arr7);
		System.out.println("heapSort: " + Arrays.toString(arr7));

		int[] arr8 = { 5, 3, 1, 4, 2 };
		mergeSort(arr8, 0, arr8.length - 1);
		System.out.println("mergeSort: " + Arrays.toString(arr8));
		
	}

	public static void quickSort(int[] a) {
		Arrays.sort(a);
	}

	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
				}
			}
		}
	}

	public static void bubbleSort(int[] a) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					isSorted = false;
				}
			}
		}
	}

	public static void bubbleSortOptimized(int[] a) {
		boolean isSorted = false;
		int lastUnsorted = a.length - 1;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < lastUnsorted; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int temp = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[temp]) {
					temp = j;
				}
			}
			swap(a, i, temp);
		}
	}

	public static void shellSort(int[] a) {
		int n = a.length;
		int d = n / 2;
		while (d > 0) {
			for (int i = d; i < n; i++) {
				int j = i - d;
				while (j >= 0 && a[j] > a[j + d]) {
					swap(a, j, j + d);
					j = j - d;
				}
			}
			d = d / 2;
		}
	}

	public static void heapSort(int[] a) {
		int arrayLength = a.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			buildMaxHeap(a, arrayLength - 1 - i);
			swap(a, 0, arrayLength - 1 - i);
		}
	}

	public static void buildMaxHeap(int[] a, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i;
			while (k * 2 + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					if (a[biggerIndex] < a[biggerIndex + 1]) {
						biggerIndex++;
					}
				}
				if (a[k] < a[biggerIndex]) {
					swap(a, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	public static void mergeSort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	public static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = a[i++];
		}

		while (j <= high) {
			temp[k++] = a[j++];
		}

		for (int k1 = 0; k1 < temp.length; k1++) {
			a[k1 + low] = temp[k1];
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
