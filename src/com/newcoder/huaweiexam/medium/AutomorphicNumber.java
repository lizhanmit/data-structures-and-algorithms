package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n(包括n)以内的自守数的个数
 * <p>
 * 本题有多组输入数据
 * <p>
 * 数据范围：
 * <p>
 * <p>
 * 输入描述：
 * int型整数
 * <p>
 * 输出描述：
 * n以内自守数的数量。
 */
public class AutomorphicNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();

            int count = countOfAutomorphicNumbers(n);

            System.out.println(count);
        }

    }

    private static int countOfAutomorphicNumbers(int n) {
        int count = 0, base = 1;
        for (int i = 0; i <= n; i++)
        {
            if (i >= base) {
                base *= 10;
            }
            if (i * i % base == i) {
                count++;
            }
        }
        return count;
    }
}
