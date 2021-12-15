package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：，。
 *
 * 本题含有多组样例输入。
 *
 * 输入描述：
 * 输入两个int整数
 *
 * 输出描述：
 * 输出结果，int型
 */
public class PutMApplesIntoNBuckets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            
            int num = numOfWaysToPutMApplesIntoNBuckets(m, n);

            System.out.println(num);
        }
    }

    private static int numOfWaysToPutMApplesIntoNBuckets(int m, int n) {
        // 递归出口：当苹果数m=0， 此时表示什么都不做，输出1种方案，再递归下去m<0，题目要求m>=0
        // 当盘子只有一个时，剩下的苹果m只能全部摆放这个盘子，递归返回1种方案，再递归下去n==0, 题目要求n>=1
        if(m == 0 || n == 1) {
            return 1;
        }
        // 当盘子数大于苹果数，一定有n-m个盘子空着，而且每个盘子都一样，因此numOfWaysToPutMApplesIntoNBuckets(m,n)==numOfWaysToPutMApplesIntoNBuckets(m,m)
        if(n > m) {
            return numOfWaysToPutMApplesIntoNBuckets(m, m);
        } else {
            // 当盘子数<=苹果数，有两种情况：
            // 1.至少有一个盘子可以不放，因此numOfWaysToPutMApplesIntoNBuckets(m, n-1)
            // 2.至少每个盘子都有一个苹果，摆放后苹果数为(m-n)，因此numOfWaysToPutMApplesIntoNBuckets(m-n, n)
            return numOfWaysToPutMApplesIntoNBuckets(m, n - 1) + numOfWaysToPutMApplesIntoNBuckets(m - n, n);
        }
    }
}
