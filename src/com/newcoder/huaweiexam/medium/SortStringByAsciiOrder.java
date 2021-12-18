package com.newcoder.huaweiexam.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 *
 * 本题含有多组样例输入。
 *
 * 数据范围：每组输入的字符串长度满足
 *
 * 输入描述：
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 *
 * 输出描述：
 * Lily的所有图片按照从小到大的顺序输出
 */
public class SortStringByAsciiOrder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();

            //String sortedStr = sortByAsciiOrder(str);
            String sortedStr = sortByAsciiOrder2(str);

            System.out.println(sortedStr);
        }
    }

    // use Arrays.sort()
    private static String sortByAsciiOrder(String str) {
        char[] charArr = str.toCharArray();

        Arrays.sort(charArr);

        return String.valueOf(charArr);
    }

    private static String sortByAsciiOrder2(String str) {
        int a[] = new int[128];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int k = str.charAt(i); //统计出现次数
            a[k]++;
        }
        for (int j = 48; j < a.length; j++) { //从'0'开始输出
            if (a[j] != 0)
                for (int b = 0; b < a[j]; b++)
                    sb.append((char) j);
        }

        return sb.toString();
    }
}
