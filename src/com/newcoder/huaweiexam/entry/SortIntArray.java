package com.newcoder.huaweiexam.entry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 数据范围：  ，元素大小满足
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述：
 * 输出排好序的数字
 *
 * 示例1
 * 输入：
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 复制
 * 输出：
 * 1 2 3 4 9 25 55 64
 * 复制
 * 示例2
 * 输入：
 * 5
 * 1 2 3 4 5
 * 1
 * 复制
 * 输出：
 * 5 4 3 2 1
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
