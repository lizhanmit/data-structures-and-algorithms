package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 本题含有多组样例输入。
 * 数据范围：数据组数：，
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一个int类型数字
 *
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 */
public class MaxNumOfContinuousBit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int input = in.nextInt();

            int maxNumOfContinuousOne = maxNumOfContinuousOne(input);

            System.out.println(maxNumOfContinuousOne);
        }
    }

    private static int maxNumOfContinuousOne(int n) {
        int maxNumOfContinuousOne = 0;
        int countOfOne = 0;

        while (n !=0) {
            if ((n & 1) == 1) {
                countOfOne++;
                maxNumOfContinuousOne = Math.max(countOfOne, maxNumOfContinuousOne);
            } else {
                countOfOne = 0;
            }

            n >>>= 1;
        }

        return maxNumOfContinuousOne;
    }
}
