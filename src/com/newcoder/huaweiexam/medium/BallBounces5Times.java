package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 *
 *
 * 数据范围：输入的小球初始高度满足  ，且保证是一个整数
 *
 * 输入描述：
 * 输入起始高度，int型
 *
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 */
public class BallBounces5Times {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        //func(n);
        func2(n);
    }

    private static void func(int n) {
        double height = Double.valueOf(n);
        double sumDistance = height + (height / 2) * 2 + (height / 4) * 2 + (height / 8) * 2 + (height / 16) * 2;
        double heightOf5thBounce = height / 32;
        System.out.println(String.format("%.6f", sumDistance));
        System.out.println(String.format("%.6f", heightOf5thBounce));
    }

    private static void func2(int n) {
        double sumDistance = Double.valueOf(n);

        double tempHeight = sumDistance / 2;
        for (int i = 1; i < 5; i++) {
            sumDistance += tempHeight * 2;
            tempHeight = tempHeight / 2;
        }

        System.out.println(String.format("%.6f", sumDistance));
        System.out.println(String.format("%.6f", tempHeight));
    }
}
