package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 * 注意本题有多组样例输入。
 * 数据范围：数据组数：
 * 进阶：时间复杂度：，空间复杂度：
 *
 * 输入描述：
 * 输入一个ip地址，保证不包含空格
 *
 * 输出描述：
 * 返回判断的结果YES or NO
 */
public class ValidIPAddress {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String input = in.nextLine();

            String validness = validnessOfIPAddress(input);

            System.out.println(validness);
        }
    }

    private static String validnessOfIPAddress(String ipAddress) {
        String[] strArr = ipAddress.split("\\.");

        if (strArr.length != 4) {
            return NO;
        }

        for (String s : strArr) {

            if (s.length() > 1 && s.startsWith("0")) {
                return NO;
            }

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return NO;
                }
            }

            try {
                int element = Integer.parseInt(s);

                if (element < 0 || element > 255) {
                    return NO;
                }
            } catch (NumberFormatException e) {
                return NO;
            }

        }

        return YES;
    }
}
