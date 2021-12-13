package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * 数据范围：字符串长度
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一个仅包含小写字母的字符串
 *
 * 输出描述：
 * 返回最长回文子串的长度
 */
public class LengthOfLongestPalindromicSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        int len = LenOfLongestPalindromicSubstring(input);

        System.out.println(len);
    }

    // 寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串。（中心扩散法）
    private static int LenOfLongestPalindromicSubstring(String str) {
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
}

