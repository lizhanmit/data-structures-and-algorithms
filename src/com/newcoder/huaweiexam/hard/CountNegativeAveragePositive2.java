package com.newcoder.huaweiexam.hard;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 描述
 * 输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾。
 *
 * 数据范围： ，其中每个数都满足
 * 输入描述：
 * 输入任意个整数，每行输入一个。
 *
 * 输出描述：
 * 输出负数个数以及所有非负数的平均值
 *
 * 示例1
 * 输入：
 * -13
 * -4
 * -7
 * 复制
 * 输出：
 * 3
 * 0.0
 * 复制
 * 示例2
 * 输入：
 * -12
 * 1
 * 2
 * 复制
 * 输出：
 * 1
 * 1.5
 */
public class CountNegativeAveragePositive2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numOfNegatives = 0;
        int numOfPositives = 0;
        int sumOfPositives = 0;
        float avgOfPositives = 0.0f;

        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0) {
                numOfNegatives++;
            } else {
                numOfPositives++;
                sumOfPositives += num;
            }
        }

        if (numOfPositives != 0) {
          avgOfPositives = (float) sumOfPositives / numOfPositives;
        }

        System.out.println(numOfNegatives);
        System.out.println(String.format("%.1f", avgOfPositives));
    }
}
