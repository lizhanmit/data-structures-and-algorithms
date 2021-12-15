package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 *
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 */
public class MaxLengthOfCommonSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int maxLen = maxLengthOfCommonSubstring(s1, s2);

        System.out.println(maxLen);
    }

    // iterate short string, check if long string contains it
    private static int maxLengthOfCommonSubstring(String s1, String s2) {
        int maxLength = 0;

        String shortStr, longStr;

        if (s1.length() < s2.length()) {
            shortStr = s1;
            longStr = s2;
        } else {
            shortStr = s2;
            longStr = s1;
        }

        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = shortStr.length(); j > i; j--) {
                if (longStr.contains(shortStr.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                    break;
                }
            }

            if (maxLength >= shortStr.length() - i) {
                break;
            }
        }

        return maxLength;
    }
}
