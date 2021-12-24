package com.newcoder.huaweiexam.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 描述
 * 输入n个整数，输出其中最小的k个整数并按升序输出
 *
 * 本题有多组输入样例
 *
 * 数据范围： ，输入的整数满足
 * 输入描述：
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 *
 * 输出描述：
 * 输出一个从小到大排序的整数数组
 *
 * 示例1
 * 输入：
 * 5 2
 * 1 3 5 7 2
 * 复制
 * 输出：
 * 1 2
 */
public class SmallestKIntegersInNIntegers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            //int[] sortedArr = smallestKIntegers(arr, k);
            int[] sortedArr = smallestKIntegers2(arr, k);

            for (int i : sortedArr) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    private static int[] smallestKIntegers(int[] arr, int k) {
        Arrays.sort(arr);

        return Arrays.copyOf(arr, k);
    }

    // use priority queue
    private static int[] smallestKIntegers2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer i : arr) {
            if (pq.size() < k) {
                pq.offer(i);
            } else if (pq.size() == k && i < pq.peek()) {
                pq.poll();
                pq.offer(i);
            }
        }

        int[] sortedArr = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            sortedArr[i] = pq.poll();
        }

        return sortedArr;
    }

}
