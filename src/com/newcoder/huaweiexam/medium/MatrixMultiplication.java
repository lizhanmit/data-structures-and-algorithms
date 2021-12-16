package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 * <p>
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 输入包含多组数据，每组数据包含：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 * <p>
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 */
public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[][] m1 = new int[x][y];
            int[][] m2 = new int[y][z];
            int[][] r = new int[x][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    m1[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    m2[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < y; k++) {
                        r[i][j] = r[i][j] + m1[i][k] * m2[k][j];
                    }
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(r[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
