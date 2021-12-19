package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围：
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class CountCharacterFrequencyInString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int count = countCharacterFrequency(s1, s2);

        System.out.println(count);
    }

    private static int countCharacterFrequency(String s1, String s2) {
        return s1.length() - s1.toLowerCase().replaceAll(s2.toLowerCase(), "").length();
    }
}
