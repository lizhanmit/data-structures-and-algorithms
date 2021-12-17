package com.newcoder.huaweiexam.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 * <p>
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * <p>
 * 本题含有多组数据。
 * <p>
 * 数据范围：输入的名字长度满足
 * <p>
 * 输入描述：
 * 整数N，后续N个名字
 * <p>
 * 输出描述：
 * 每个名称可能的最大漂亮程度
 */
public class BeautifulDegreeOfName {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String str = in.next();
                int s[] = new int[26];
                for (int j = 0; j < str.length(); j++) {
                    s[str.charAt(j) - 'a']++;
                }
                Arrays.sort(s);
                int degree = 26, sum = 0;
                for (int j = s.length - 1; j >= 0 && s[j] > 0; j--) {
                    sum += s[j] * degree;
                    degree--;
                }
                System.out.println(sum);
            }
        }
    }
}
