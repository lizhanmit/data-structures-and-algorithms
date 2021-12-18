package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * <p>
 * 2 5 9 14
 * <p>
 * 4 8 13
 * <p>
 * 7 12
 * <p>
 * 11
 * <p>
 * <p>
 * 请注意本题含有多组样例输入。
 * <p>
 * 输入描述：
 * 输入正整数N（N不大于100）
 * <p>
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 */
public class SnakelikeMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();

            //printSnakelikeMatrix(n);
            printSnakelikeMatrix2(n);
        }
    }

    private static void printSnakelikeMatrix(int n) {
        int[][] result = new int[n][];    //建立数组（n行）
        int t = 1;    //记录依次赋予的数组值
        for (int i = 0; i < n; i++) {
            result[i] = new int[n - i];    //数组第i行有n-i个元素
            for (int j = 0; j < i + 1; j++) {    //对第i个对角线赋值
                result[i - j][j] = t;
                t++;
            }
        }

        //输出数组值
        for (int[] a : result) {
            for (int a1 : a)
                System.out.print(a1 + " ");
            System.out.println();
        }
    }

    private static void printSnakelikeMatrix2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print((i + j) * (i + j + 1) / 2 - (i - 1));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
