package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 将一个字符串str的内容颠倒过来，并输出。
 *
 * 数据范围：
 * 输入描述：
 * 输入一个字符串，可以有空格
 *
 * 输出描述：
 * 输出逆序的字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //String reversedStr = reverseStr(input);
        String reversedStr = reverseStr2(input);

        System.out.println(reversedStr);
    }

    private static String reverseStr2(String str) {
        char[] charArr = str.toCharArray();

        int i = 0;
        int j = str.length() - 1;

        char temp;

        while (i < j) {
            temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;

            i++;
            j--;
        }

        return new String(charArr); // or String.valueOf(charArr)
    }

    // use StringBuilder reverse()
    private static String reverseStr(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
