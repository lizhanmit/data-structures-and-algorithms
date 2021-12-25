package com.newcoder.huaweiexam.veryhard;

import java.util.Scanner;

/**
 * 描述
 * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 * 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
 * 如有多个解，请输出任意一个。
 * 请注意本题含有多组样例输入！
 * <p>
 * <p>
 * 输入描述：
 * 输入一个真分数，String型
 * <p>
 * 输出描述：
 * 输出分解后的string
 * <p>
 * 示例1
 * 输入：
 * 8/11
 * 2/4
 * 复制
 * 输出：
 * 1/2+1/5+1/55+1/110
 * 1/3+1/6
 * 复制
 * 说明：
 * 第二个样例直接输出1/2也是可以的
 */
public class DivideProperFractionIntoEgyptFraction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] str = sc.next().split("/");
            // 分子
            int a = Integer.parseInt(str[0]);
            // 分母
            int b = Integer.parseInt(str[1]);

            StringBuilder sb = new StringBuilder();
            process(a, b, sb);
            System.out.println(sb);
        }
    }

    private static void process(int a, int b, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append("+");
        }

        int x = b / a;

        if (a == 1 || b % a == 0) {
            sb.append("1/").append(x);
        } else {
            int y = b % a;
            sb.append("1/").append(x + 1);
            process(a - y, b * (x + 1), sb);
        }
    }
}
