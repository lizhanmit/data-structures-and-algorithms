package com.newcoder.huaweiexam.medium;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 *
 * 数据范围：
 * 输入描述：
 * 输入一行没有空格的字符串。
 *
 * 输出描述：
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 */
public class CountDistinctCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        //int count = countDistinctCharacters(str);
        int count = countDistinctCharacters2(str);

        System.out.println(count);
    }

    // use HashSet
    private static int countDistinctCharacters(String str) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        return set.size();
    }

    // use BitSet
    private static int countDistinctCharacters2(String str) {
        BitSet bitSet = new BitSet(128);

        for (int i = 0; i < str.length(); i++) {
            bitSet.set(str.charAt(i));
        }

        return bitSet.cardinality();
    }
}
