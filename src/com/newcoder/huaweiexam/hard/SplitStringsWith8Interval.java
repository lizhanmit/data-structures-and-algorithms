package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * （注：本题有多组输入）
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 */
public class SplitStringsWith8Interval {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (!str.isEmpty()) {
                printSplitStrings(str);
            }
        }
    }

    private static void printSplitStrings(String str) {
        if (str.length() <= 8) {
            System.out.print(str);
            for (int i = 0; i < 8 - str.length(); i++) {
                System.out.print("0");
            }
            System.out.println();
        } else {
            printSplitStrings(str.substring(0, 8));
            printSplitStrings(str.substring(8));
        }
    }
}
