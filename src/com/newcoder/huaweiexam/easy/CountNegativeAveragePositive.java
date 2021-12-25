package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算
 *
 * 数据范围：  ，输入的整数都满足
 * 输入描述：
 * 本题有多组输入用例。
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 *
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
 *
 * 示例1
 * 输入：
 * 5
 * 1 2 3 4 5
 * 10
 * 1 2 3 4 5 6 7 8 9 0
 * 复制
 * 输出：
 * 0 3.0
 * 0 5.0
 * 复制
 * 示例2
 * 输入：
 * 3
 * 0 0 0
 * 复制
 * 输出：
 * 0 0.0
 */
public class CountNegativeAveragePositive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int numOfNegatives = 0;
            int numOfPositives = 0;
            int sumOfPositives = 0;
            float avgOfPositives = 0.0f;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num < 0) {
                    numOfNegatives++;
                } else if (num > 0) {
                    numOfPositives++;
                    sumOfPositives += num;
                }
            }

            if (numOfPositives > 0) {
                avgOfPositives = (float) sumOfPositives / numOfPositives;
            }

            System.out.print(numOfNegatives + " ");
            System.out.println(String.format("%.1f", avgOfPositives));
        }
    }
}
