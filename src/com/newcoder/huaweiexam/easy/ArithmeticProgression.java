package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 *
 * 本题有多组输入
 *
 * 数据范围：1 <= n <= 1000
 * 输入描述：
 * 输入一个正整数n。
 *
 * 输出描述：
 * 输出一个相加后的整数。
 */
public class ArithmeticProgression {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int input = in.nextInt();

            int sum = sumOfArithmeticProgression(input);

            System.out.println(sum);
        }
    }


    private static int sumOfArithmeticProgression(int n) {
        int a1 = 2;
        int d = 3;

        int an = valueOfNthItem(a1, n, d);

        return sumOfArithmeticProgression(a1, an, n);
    }

    // Sn = n * (a1 + an) / 2
    private static int sumOfArithmeticProgression(int a1, int an, int n) {
        return n * (a1 + an) / 2;
    }

    // an = a1 + (n - 1) * d
    private static int valueOfNthItem(int a1, int n, int d) {
        return a1 + (n - 1) * d;
    }
}
