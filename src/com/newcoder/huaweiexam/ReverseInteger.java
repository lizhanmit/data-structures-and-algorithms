package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述：
 * 输出该字符串反转后的字符串。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        //reverseInteger(input);
        reverseInteger2(input);
    }

    private static void reverseInteger2(int input) {
        if (input == 0) {
            System.out.print(input);
        }

        while (input > 0) {
            System.out.print(input % 10);

            input /= 10;
        }
    }

    private static void reverseInteger(int input) {
        String str = String.valueOf(input);

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }


}
