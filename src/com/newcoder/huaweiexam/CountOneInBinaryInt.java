package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 *
 * 数据范围：
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 计算整数二进制中1的个数
 */
public class CountOneInBinaryInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int input = in.nextInt();
            //int numOfOne = numOfOneInBinaryInt(input);
            int numOfOne = numOfOneInBinaryInt2(input);

            System.out.println(numOfOne);
        }
    }

    // use Integer.toBinaryString()
    private static int numOfOneInBinaryInt(int n) {
        int numOfOne = 0;

        String binaryStr = Integer.toBinaryString(n);
        for (char c : binaryStr.toCharArray()) {
            if (c == '1') {
                numOfOne++;
            }
        }

        return numOfOne;
    }

    // check if n & 1 is 1, then n >>> 1
    private static int numOfOneInBinaryInt2(int n) {
        int numOfOne = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                numOfOne++;
            }

            n >>>= 1;
        }

        return numOfOne;
    }
}
