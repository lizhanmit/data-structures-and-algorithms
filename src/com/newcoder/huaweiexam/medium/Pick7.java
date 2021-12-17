package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 输出小于等于 n 的与 7 有关数字的个数，包括 7 的倍数，还有包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * 数据范围：
 *
 * 本题有多组输入
 * 输入描述：
 * 多组输入每组输入 1 个正整数 n 。( n 不大于 30000 )
 *
 * 输出描述：
 * 不大于n的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 */
public class Pick7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int input = in.nextInt();

            int countOf7RelatedNumber = countOf7RelatedNumber(input);

            System.out.println(countOf7RelatedNumber);
        }
    }

    private static int countOf7RelatedNumber(int n) {
        int count = 0;

        if (n < 7) {
            return count;
        }

        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                count++;
            }
        }

        return count;
    }
}