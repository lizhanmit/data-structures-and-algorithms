package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 数据范围：
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入：
 * 1516000
 * 复制
 * 输出：
 * 0006151
 * 复制
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 */
public class ReverseInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        //reverseInteger(input);
        reverseInteger2(input);
    }

    private static void reverseInteger2(int input) {
        if (input == 0) {
            System.out.print(input);
        }

        while (input > 0) {
            System.out.print(input % 10);

            input /= 10;
        }
    }

    private static void reverseInteger(int input) {
        String str = String.valueOf(input);

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }


}
