package com.newcoder.huaweiexam.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 找出字符串中第一个只出现一次的字符
 *
 *
 * 数据范围：输入的字符串长度满足
 *
 *
 * 输入描述：
 * 输入几个非空字符串
 *
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 */
public class FirstCharAppearingOnceInString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine())
        {
            String str = in.nextLine();
            int result = firstCharAppearingOnceInString(str);

            if (result == -1) {
                System.out.println(result);
            }
            else {
                System.out.println((char) result);
            }
        }
    }

    private static int firstCharAppearingOnceInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = str.toCharArray();

        for (char ch : charArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : charArr) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return -1;
    }
}
