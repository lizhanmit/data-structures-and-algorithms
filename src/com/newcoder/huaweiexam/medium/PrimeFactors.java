package com.newcoder.huaweiexam.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 *
 * 数据范围：
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 */
public class PrimeFactors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        printPrimeFactors(n);
    }

    // 一个数的质数因子一定是小于或等于平方根的
    private static void printPrimeFactors(long n) {
        for (long i = 2; i <= (long) Math.sqrt(n); ++i) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        System.out.println(n == 1 ? "" : n + " ");
    }
}
