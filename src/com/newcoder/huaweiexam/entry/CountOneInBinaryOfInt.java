package com.newcoder.huaweiexam.entry;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 * 复制
 * 输出：
 * 2
 * 复制
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 */
public class CountOneInBinaryOfInt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        //int count = countOneInBinaryOfInt(n);
        int count = countOneInBinaryOfInt2(n);

        System.out.println(count);
    }

    private static int countOneInBinaryOfInt(int n) {
        int count = 0;

        String binaryStr = Integer.toBinaryString(n);

        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    private static int countOneInBinaryOfInt2(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }

            n = n >>> 1;
        }

        return count;
    }
}
