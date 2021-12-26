package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * 数据范围：字符串长度：
 * 字符串中可能包含空格或其他字符
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 *
 * 输出描述：
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 *
 * 示例1
 * 输入：
 * add123#$%#%#O
 * 150175017(&^%&$vabovbao
 * A 1 0 11
 * 复制
 * 输出：
 * 1
 * 0
 * 1
 */
public class CountCapitalLetters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();

            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    count++;
                }
            }

            System.out.println(count);

            // or use regexp
            //System.out.println(str.replaceAll("[^A-Z]+", "").length());
        }
    }
}
