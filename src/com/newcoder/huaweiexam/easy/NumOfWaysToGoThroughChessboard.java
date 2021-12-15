package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 注：沿棋盘格之间的边缘线行走
 *
 * 本题含有多组样例输入。
 *
 * 数据范围： 1 <= n,m <= 8
 *
 *
 * 输入描述：
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 *
 * 输出描述：
 * 每组样例输出一行结果
 */
public class NumOfWaysToGoThroughChessboard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            int numOfWays = numOfWays(n, m);

            System.out.println(numOfWays);
        }
    }

    private static int numOfWays(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }

        return numOfWays(n - 1, m) + numOfWays(n, m - 1);
    }
}
