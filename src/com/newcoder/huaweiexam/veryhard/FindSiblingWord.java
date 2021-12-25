package com.newcoder.huaweiexam.veryhard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 str ，让你寻找 str 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 *
 * 数据范围：，输入的字符串长度满足  ，
 * 输入描述：
 * 先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
 * 输出描述：
 * 输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入：
 * 3 abc bca cab abc 1
 * 复制
 * 输出：
 * 2
 * bca
 * 复制
 * 示例2
 * 输入：
 * 6 cab ad abcd cba abc bca abc 1
 * 复制
 * 输出：
 * 3
 * bca
 * 复制
 * 说明：
 * abc的兄弟单词有cab cba bca，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 */
public class FindSiblingWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();

            String[] strArr = new String[n];
            for (int i = 0; i < n; i++) {
                strArr[i] = in.next();
            }

            String wordToMatch = in.next();
            int k = in.nextInt();

            printSiblingWord(strArr, wordToMatch, k);
        }
    }

    private static void printSiblingWord(String[] strArr, String wordToMatch, int k) {
        List<String> siblingWords = new ArrayList<>();

        char[] wordToMatchCharArr = wordToMatch.toCharArray();
        Arrays.sort(wordToMatchCharArr);
        String sortedWordToMatch = new String(wordToMatchCharArr);

        for (String s : strArr) {
            if (s.length() == wordToMatch.length() && !s.equals(wordToMatch)) {
                char[] charArr = s.toCharArray();
                Arrays.sort(charArr);
                String sortedWord = new String(charArr);
                if (sortedWord.equals(sortedWordToMatch)) {
                    siblingWords.add(s);
                }
            }
        }

        System.out.println(siblingWords.size());

        if (k <= siblingWords.size()) {
            Collections.sort(siblingWords);
            System.out.println(siblingWords.get(k-1));
        }
    }
}
