package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 *
 *
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 *
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 *
 * 数据范围：
 *
 * 本题有多组输入数据
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出返回的int值
 */
public class YanghuiTriangleVariation {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int input = in.nextInt();

            int placeOfFirstEvenNumber = placeOfFirstEvenNumber(input);

            System.out.println(placeOfFirstEvenNumber);
        }
    }

    // find the pattern:
    // when n <= 2, place is -1
    // when n % 4 is 0, place is 3
    // when n % 4 is 1, place is 2
    // when n % 4 is 2, place is 4
    // when n % 4 is 3, place is 2
    private static int placeOfFirstEvenNumber(int n) {
        if (n <= 2) {
            return -1;
        }

        if (n % 4 == 0) {
            return 3;
        }

        if (n % 4 == 1 || n % 4 == 3) {
            return 2;
        }

        if (n % 4 == 2) {
            return  4;
        }

        return -1;
    }
}
