package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * <p>
 * 本题包含多组输入。
 * <p>
 * 数据范围：输入的字符串长度满足
 * <p>
 * 输入描述：
 * 输入一行字符串，可以有空格
 * <p>
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 */
public class CountDifferentTypesOfCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.nextLine();

            //countDifferentTypesOfCharacters(str);

            countDifferentTypesOfCharacters2(str);
        }
    }

    private static void countDifferentTypesOfCharacters2(String str) {
        int letters = 0;
        int spaces = 0;
        int digits = 0;
        int others = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isSpaceChar(c)) {
                spaces++;
            } else {
                others++;
            }
        }

        System.out.println(letters);
        System.out.println(spaces);
        System.out.println(digits);
        System.out.println(others);
    }

    private static void countDifferentTypesOfCharacters(String str) {
        String strAfterRemovingLetters = str.replaceAll("[A-Za-z]+", "");

        System.out.println(str.length() - strAfterRemovingLetters.length());

        String strAfterRemovingWhiteSpaces = strAfterRemovingLetters.replaceAll(" ", "");

        System.out.println(strAfterRemovingLetters.length() - strAfterRemovingWhiteSpaces.length());

        String strAfterRemovingNumbers = strAfterRemovingWhiteSpaces.replaceAll("[0-9]+", "");

        System.out.println(strAfterRemovingWhiteSpaces.length() - strAfterRemovingNumbers.length());

        System.out.println(strAfterRemovingNumbers.length());
    }


}
