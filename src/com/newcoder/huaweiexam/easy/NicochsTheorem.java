package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 * 数据范围：数据组数：，
 * 进阶：时间复杂度：，空间复杂度：
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出分解后的string
 */
public class NicochsTheorem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int input = in.nextInt();

            String str = nicochsTheoremStr(input);
            System.out.println(str);
        }
    }

    private static String nicochsTheoremStr(int n) {
        int a = n * (n - 1) + 1;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);

        for (int i = 1; i < n; i++) {
            a += 2;
            stringBuilder.append("+").append(a);
        }

        return stringBuilder.toString();
    }
}
