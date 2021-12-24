package com.newcoder.huaweiexam.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 *
 * 数据范围：字符串长度  ， 保证每组输入都至少含有一个数字
 * 输入描述：
 * 输入一个字符串。1<=len(字符串)<=200
 *
 * 输出描述：
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 *
 * 示例1
 * 输入：
 * abcd12345ed125ss123058789
 * a8a72a6a5yy98y65ee1r2
 * 复制
 * 输出：
 * 123058789,9
 * 729865,2
 * 复制
 * 说明：
 * 样例一最长的数字子串为123058789，长度为9
 * 样例二最长的数字子串有72,98,65，长度都为2
 */
public class LongestNumberInString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();

            printLongestNumber(str);
        }
    }

    // When there could be more than one longest strings with the same length,
    // instead of using Map and sorting by value,
    // use max to record the maximum length, and pick strings whose length is equal to max.
    private static void printLongestNumber(String str) {
        String[] strArr = str.split("[^0-9]+");

        List<String> strWithMaxLenList = new ArrayList<>();

        int maxLen = 0;
        for (String s : strArr) {
            if (s.length() > maxLen) {
                strWithMaxLenList.clear();
                strWithMaxLenList.add(s);
                maxLen = s.length();
            } else if (s.length() == maxLen) {
                strWithMaxLenList.add(s);
            }
        }

        strWithMaxLenList.forEach(System.out::print);
        System.out.println("," + maxLen);
    }
}
