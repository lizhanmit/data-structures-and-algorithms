package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 *
 * 本题有多组数据。
 *
 * 数据范围：每组输入满足
 * 输入描述：
 * 多行输入，一行输入一个int型整数表示第n个月
 *
 * 输出描述：
 * 每一行输出对应的兔子总数
 */
public class CountRabbitsInMonthN {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int numOfMonth = in.nextInt();

            //int count = countRabbitsInMonthN(numOfMonth);
            int count = countRabbitsInMonthN2(numOfMonth);

            System.out.println(count);
        }
    }

    private static int countRabbitsInMonthN(int month) {
        int countOfOneMonthRabbits = 1;
        int countOfTwoMonthsRabbits = 0;
        int countOfThreeAndMoreMonthsRabbits = 0;

        for (int i = 1; i < month; i++) {
            countOfThreeAndMoreMonthsRabbits += countOfTwoMonthsRabbits;
            countOfTwoMonthsRabbits = countOfOneMonthRabbits;
            countOfOneMonthRabbits = countOfThreeAndMoreMonthsRabbits;
        }

        return countOfOneMonthRabbits + countOfTwoMonthsRabbits + countOfThreeAndMoreMonthsRabbits;
    }

    // Fibonacci
    private static int countRabbitsInMonthN2(int month) {
        if (month < 3) {
            return 1;
        }

        return countRabbitsInMonthN2(month - 1) + countRabbitsInMonthN2(month - 2);
    }
}
