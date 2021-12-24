package com.newcoder.huaweiexam.hard;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 描述
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 *
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 *
 * 示例1
 * 输入：
 * bc
 * abc
 * apgmlivuembu
 * tyjmrcuneguxmsqwjslqvfmw
 * bca
 * abc
 * 复制
 * 输出：
 * true
 * false
 * true
 * 复制
 * 说明：
 * 第一组样例:
 * bc
 * abc
 * 其中abc含有bc，输出"true"
 * 第二组样例，上面短字符串的a就没有在下面长字符串出现，输出"false"
 */
public class CharacterMatchInShortAndLongStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String shortStr = in.next();
            String longStr = in.next();

            boolean doAllCharsExist = doAllCharsExist(shortStr, longStr);

            System.out.println(doAllCharsExist);
        }
    }

    private static boolean doAllCharsExist(String shortStr, String longStr) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < longStr.length(); i++) {
            set.add(longStr.charAt(i));
        }

        for (int i = 0; i < shortStr.length(); i++) {
            if (!set.contains(shortStr.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
