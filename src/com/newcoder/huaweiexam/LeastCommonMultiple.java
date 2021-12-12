package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 数据范围：1 <= a,b <= 100000
 * 输入描述：
 * 输入两个正整数A和B。
 *
 * 输出描述：
 * 输出A和B的最小公倍数。
 */
public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int leastCommonMultiple = leastCommonMultiple(a, b);

        System.out.println(leastCommonMultiple);
    }

    // leastCommonMultiple = a * b / greatestCommonDivisor
    // 求greatestCommonDivisor最大公约数有两种方法：更相减损法、辗转相处法
    // 更相减损法是拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，这两个数任意一个就是最大公约数。
    private static int leastCommonMultiple(int a, int b) {
        if (a == b) {
            return a;
        }

        return a * b / greatestCommonDivisor(a, b);
    }

    private static int greatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }

        if (a > b) {
            int diff = a - b;
            return greatestCommonDivisor(diff, b);
        } else {
            int diff = b - a;
            return greatestCommonDivisor(diff, a);
        }
    }
}
