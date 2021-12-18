package com.newcoder.huaweiexam.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 * 数据范围：输入的字符串长度满足
 *
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 */
public class SortStringBySpecificRule {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextLine()) {
            String str = in.nextLine();

            String sortedStr = sortStringBySpecificRule(str);

            System.out.println(sortedStr);
        }
    }

    private static String sortStringBySpecificRule(String str) {
        List<Character> letters = new ArrayList<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }

        letters.sort((c1, c2) -> Character.toLowerCase(c1) - Character.toLowerCase(c2));

        StringBuilder sb = new StringBuilder();

        int indexOfLettersList = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(letters.get(indexOfLettersList));
                indexOfLettersList++;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
