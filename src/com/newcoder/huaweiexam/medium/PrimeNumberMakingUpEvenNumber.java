package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：输入的数据满足
 * 输入描述：
 * 输入一个大于2的偶数
 * <p>
 * 输出描述：
 * 输出两个素数
 */
public class PrimeNumberMakingUpEvenNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int num = in.nextInt();
            int[] numArr = twoPrimeNumbersThatMakeUpEvenNumber(num);

            System.out.println(numArr[0]);
            System.out.println(numArr[1]);
        }
    }

    private static int[] twoPrimeNumbersThatMakeUpEvenNumber(int num) {
        int[] primeArr = new int[2];

        for (int i = num / 2; i < num - 1; i++) {
            if (isPrime(i) && isPrime(num - i)) {
                primeArr[0] = num - i;
                primeArr[1] = i;
                return primeArr;
            }
        }

        return primeArr;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
