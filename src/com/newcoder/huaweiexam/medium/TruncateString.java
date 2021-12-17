package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 *
 * 本题输入含有多组数据
 *
 * 数据范围：字符串长度满足  ，
 * 输入描述：
 * 1.输入待截取的字符串
 *
 * 2.输入一个正整数k，代表截取的长度
 *
 * 输出描述：
 * 截取后的字符串
 */
public class TruncateString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();
            int numOfCharToTruncate = in.nextInt();

            String subStr = truncateString(str, numOfCharToTruncate);

            System.out.println(subStr);
        }
    }

    private static String truncateString(String str, int numOfCharToTruncate) {
        return str.substring(0, numOfCharToTruncate);
    }
}
