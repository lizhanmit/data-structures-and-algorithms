package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足
 *
 * 本题有多组输入
 * 输入描述：
 * 一组或多组字符串。每组占一行
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 复制
 * 输出：
 * OK
 * NG
 * NG
 * OK
 */
public class PasswordVerification {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();

            String result = verify(str);

            System.out.println(result);
        }
    }

    private static String verify(String str) {
        String NG = "NG";
        String OK = "OK";

        if (str.length() <= 8 || numOfSignTypes(str) < 3 || hasCommonSubstring(str, 0, 3)) {
            return NG;
        } else {
            return OK;
        }

    }

    private static boolean hasCommonSubstring(String str, int left, int right) {
        if (right >= str.length()) {
            return false;
        }

        if (str.substring(right).contains(str.substring(left, right))) {
            return true;
        } else {
            return hasCommonSubstring(str,left + 1,right + 1);
        }
    }

    private static int numOfSignTypes(String str) {
        int hasUppercase = 0;
        int hasLowercases = 0;
        int hasDigit = 0;
        int hasOther = 0;


        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                hasUppercase = 1;
            } else if (Character.isLowerCase(str.charAt(i))) {
                hasLowercases = 1;
            } else if (Character.isDigit(str.charAt(i))) {
                hasDigit = 1;
            } else {
                hasOther = 1;
            }
        }

        return hasUppercase + hasLowercases + hasDigit + hasOther;
    }
}
