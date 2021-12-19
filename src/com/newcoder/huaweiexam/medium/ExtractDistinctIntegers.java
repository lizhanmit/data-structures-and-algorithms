package com.newcoder.huaweiexam.medium;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围：
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 */
public class ExtractDistinctIntegers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int processedN = extractDistinctIntegers(n);

        System.out.println(processedN);
    }

    private static int extractDistinctIntegers(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new LinkedHashSet<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (set.add(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        return Integer.valueOf(sb.toString());
    }
}
