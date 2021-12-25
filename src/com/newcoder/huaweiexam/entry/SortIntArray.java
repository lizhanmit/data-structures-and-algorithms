package com.newcoder.huaweiexam.entry;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class SortIntArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sortFlat = in.nextInt();

        printSortedArr(arr, sortFlat);
    }

    private static void printSortedArr(Integer[] arr, int sortFlat) {
        if (sortFlat == 0) {
            Arrays.stream(arr).sorted((i1, i2) -> i1 - i2).forEach(i -> System.out.print(i + " "));
        } else if (sortFlat == 1) {
            Arrays.stream(arr).sorted((i1, i2) -> i2 - i1).forEach(i -> System.out.print(i + " "));
        }
    }
}
