package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 输入n，请输出n以内(含n)完全数的个数。
 *
 * 数据范围：
 *
 *
 * 本题输入含有多组样例。
 *
 * 输入描述：
 * 输入一个数字n
 *
 * 输出描述：
 * 输出不超过n的完全数的个数
 */
public class PerfectNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();

            int numOfPerfectNumbers = numOfPerfectNumbersWithinN(n);

            System.out.println(numOfPerfectNumbers);
        }
    }

    private static int numOfPerfectNumbersWithinN(int n) {
        int numOfPerfectNumbers = 0;

        for (int i = 6; i <= n; i++) {  // start from 6 because 6 is the smallest perfect number
            int sum = 0;

            for (int j = 1; j < i; j++) {  // j < n because n itself is excluded
                if (i % j == 0) {
                    sum += j;
                }

                if (sum > i) {
                    break;
                }
            }

            if (sum == i) {
                numOfPerfectNumbers++;
            }
        }

        return numOfPerfectNumbers;
    }
}
