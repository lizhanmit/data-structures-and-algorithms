package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 数据范围：字符串长度满足
 * 输入描述：
 * 输入一个字符串（字符串的长度不超过2500）
 *
 * 输出描述：
 * 返回有效密码串的最大长度
 *
 * 示例1
 * 输入：
 * ABBA
 * 复制
 * 输出：
 * 4
 * 复制
 * 示例2
 * 输入：
 * ABBBA
 * 复制
 * 输出：
 * 5
 * 复制
 * 示例3
 * 输入：
 * 12HHHHA
 * 复制
 * 输出：
 * 4
 */
public class PasswordInterception {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        int length = lengthOfValidPassword(str);
        //int length = lengthOfValidPassword2(str);

        System.out.println(length);
    }

    // same as LenOfLongestPalindromicSubstring
    private static int lengthOfValidPassword(String str) {
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            maxLen = Math.max(maxLen, lenOfPalindromicSubstring(str, i, i));
            maxLen = Math.max(maxLen, lenOfPalindromicSubstring(str, i, i + 1));
        }

        return maxLen;
    }

    private static int lenOfPalindromicSubstring(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length() && str.charAt(leftIndex) == str.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }

    // use dynamic programming
    private static int lengthOfValidPassword2(String str) {
        int len = str.length();
        // 状态：对比的两个字符索引起始和终止索引位置
        // 定义: 字符串s的i到j字符组成的子串是否为回文子串
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        // base case
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = true;
        }

        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 状态转移：如果左右两字符相等,同时[l+1...r-1]范围内的字符是回文子串
                // 则 [l...r] 也是回文子串
                if (str.charAt(l) == str.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    // 不断更新最大长度
                    res = Math.max(res, r - l + 1);
                }
            }
        }
        return res;
    }
}