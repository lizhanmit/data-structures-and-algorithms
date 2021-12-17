package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 * <p>
 * 本题含有多组输入数据！
 * 数据范围：字符串长度，
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入两个字符串
 * <p>
 * 输出描述：
 * 返回重复出现的字符
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            //String longestCommonSubstring = longestCommonSubstring(s1, s2);
            String longestCommonSubstring = longestCommonSubstring2(s1, s2);

            System.out.println(longestCommonSubstring);
        }
    }

    private static String longestCommonSubstring(String s1, String s2) {
        String shortStr, longStr;

        if (s1.length() < s2.length()) {
            shortStr = s1;
            longStr = s2;
        } else {
            shortStr = s2;
            longStr = s1;
        }

        int maxLen = 0, start = 0;
        for (int i = 0; i < shortStr.length(); i++) {
            // 剪枝，子串长度已经不可能超过maxLen，退出循环
            if (shortStr.length() - i + 1 <= maxLen) {
                break;
            }
            // 左指针j，右指针k, 右指针逐渐向左逼近
            for (int j = i, k = shortStr.length(); k > j; k--) {
                String subStr = shortStr.substring(i, k);
                if (longStr.contains(subStr) && maxLen < subStr.length()) {
                    maxLen = subStr.length();
                    start = j;
                    // 找到就立即返回
                    break;
                }
            }
        }
        return shortStr.substring(start, start + maxLen);
    }

    // use dynamic programming
    public static String longestCommonSubstring2(String str1, String str2) {
        String temp = "";
        // 保证str1是较短字符串
        if (str1.length() > str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int m = str1.length() + 1;
        int n = str2.length() + 1;
        // 表示在较短字符串str1以第i个字符结尾，str2中以第j个字符结尾时的公共子串长度。
        int[][] dp = new int[m][n];
        // 匹配字符，并记录最大值的str1的结尾下标
        int max = 0;
        int index = 0;
        // 从左向右递推，i为短字符串str1的结尾索引，j为str2的结尾索引
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 相等则计数
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 不断更新变量
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        // 截取最大公共子串
        return str1.substring(index - max, index);
    }
}
