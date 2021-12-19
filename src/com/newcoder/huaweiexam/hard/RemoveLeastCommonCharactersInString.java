package com.newcoder.huaweiexam.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 *
 * 数据范围：输入的字符串长度满足  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * abcdd
 * aabcddd
 * 复制
 * 输出：
 * dd
 * aaddd
 */
public class RemoveLeastCommonCharactersInString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String input = in.nextLine();

            String str = removeLeastCommonCharactersInString(input);
            System.out.println(str);
        }
    }

    private static String removeLeastCommonCharactersInString(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int min = Integer.MAX_VALUE;

        for (int frequency : map.values()) {
            min = Math.min(min, frequency);
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (map.get(ch) != min) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
