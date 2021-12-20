package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2、加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 * 本题含有多组样例输入。
 *
 * 数据范围：输入的两个字符串长度满足  ，保证输入的字符串都是大小写字母或者数字
 * 输入描述：
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述：
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 * 示例1
 * 输入：
 * abcdefg
 * BCDEFGH
 * 复制
 * 输出：
 * BCDEFGH
 * abcdefg
 */
public class StringEncryptionAndDecryption {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String strToEncrypt = in.nextLine();
            String strToDecrypt = in.nextLine();

            String encryptedStr = encrypt(strToEncrypt);
            String decryptedStr = decrypt(strToDecrypt);

            System.out.println(encryptedStr);
            System.out.println(decryptedStr);
        }
    }

    private static String decrypt(String str) {
        StringBuilder sb = new StringBuilder();
        char temp;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {

                if (str.charAt(i) == 'A') {
                    temp = 'z';
                } else if (str.charAt(i) == 'a') {
                    temp = 'Z';
                } else {
                    temp = (char) (str.charAt(i) - 1);

                    if (Character.isUpperCase(temp)) {
                        temp = Character.toLowerCase(temp);
                    } else {
                        temp = Character.toUpperCase(temp);
                    }
                }
            } else if (Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) == '0') {
                    temp = '9';
                } else {
                    temp = (char) (str.charAt(i) - 1);
                }
            } else {
                temp = str.charAt(i);
            }

            sb.append(temp);
        }
        return sb.toString();
    }

    private static String encrypt(String str) {
        StringBuilder sb = new StringBuilder();
        char temp;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {

                if (str.charAt(i) == 'Z') {
                    temp = 'a';
                } else if (str.charAt(i) == 'z') {
                    temp = 'A';
                } else {
                    temp = (char) (str.charAt(i) + 1);

                    if (Character.isUpperCase(temp)) {
                        temp = Character.toLowerCase(temp);
                    } else {
                        temp = Character.toUpperCase(temp);
                    }
                }
            } else if (Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) == '9') {
                    temp = '0';
                } else {
                    temp = (char) (str.charAt(i) + 1);
                }
            } else {
                temp = str.charAt(i);
            }

            sb.append(temp);
        }

        return sb.toString();
    }
}
