package com.newcoder.huaweiexam.medium;

import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 * 注意：本题有多组样例输入。
 *
 * 数据范围：字符串长度满足
 * 输入描述：
 * 输入一个字符串
 *
 * 输出描述：
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 */
public class EncloseIntegerByAsterisks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String input = in.nextLine();

            //String str = encloseIntegerByAsterisks(input);
            String str = encloseIntegerByAsterisks2(input);

            System.out.println(str);
        }
    }

    private static String encloseIntegerByAsterisks(String str) {
        StringBuilder sb = new StringBuilder();

        char[] charArr = str.toCharArray();

        if (charArr.length == 1) {
            if (Character.isDigit(charArr[0])) {
                return sb.append("*").append(charArr[0]).append("*").toString();
            } else {
                return str;
            }
        } else {
            if (Character.isDigit(charArr[0])) {
                sb.append("*").append(charArr[0]);
            } else {
                sb.append(charArr[0]);
            }

            for (int i = 1; i < charArr.length; i++) {
                if (Character.isDigit(charArr[i]) && Character.isDigit(charArr[i-1])) {
                    sb.append(charArr[i]);
                } else if (!Character.isDigit(charArr[i]) && Character.isDigit(charArr[i-1])) {
                    sb.append("*").append(charArr[i]);
                } else if (Character.isDigit(charArr[i]) && !Character.isDigit(charArr[i-1])) {
                    sb.append("*").append(charArr[i]);
                } else {
                    sb.append(charArr[i]);
                }
            }

            if (Character.isDigit(charArr[charArr.length - 1])) {
                sb.append("*");
            }
        }

        return sb.toString();
    }

    // use regex
    private static String encloseIntegerByAsterisks2(String str) {
        return str.replaceAll("([0-9]+)", "*$1*");
    }
}
