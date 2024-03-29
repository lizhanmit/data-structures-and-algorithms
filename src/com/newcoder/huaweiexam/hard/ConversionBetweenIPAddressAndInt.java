package com.newcoder.huaweiexam.hard;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;

/**
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 *
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 示例1
 * 输入：
 * 10.0.3.193
 * 167969729
 * 复制
 * 输出：
 * 167773121
 * 10.3.3.193
 */
public class ConversionBetweenIPAddressAndInt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String ipAddress = in.nextLine();
            String num = in.nextLine();

            String convertedNum = convertIPAddressToNum(ipAddress);
            String convertedIPAddress = convertNumToIPAddress(num);

            System.out.println(convertedNum);
            System.out.println(convertedIPAddress);
        }
    }

    private static String convertNumToIPAddress(String str) {
        StringBuilder sb = new StringBuilder();

        long num = Long.parseLong(str);
        String binaryStr = Long.toBinaryString(num);

        if (binaryStr.length() < 32) {
            for (int i = 0; i < 32 - binaryStr.length(); i++) {
                sb.append("0");
            }
        }

        String binaryStrWithZeroPadding = sb.append(binaryStr).toString();

        StringBuilder ipAddressSb = new StringBuilder();

        for (int i = 0; i < 32; i = i + 8) {
            ipAddressSb.append(Integer.parseInt(binaryStrWithZeroPadding.substring(i, i + 8), 2))
                    .append(".");
        }

        return ipAddressSb.substring(0, ipAddressSb.length() - 1);
    }

    private static String convertIPAddressToNum(String ipAddress) {
        StringBuilder sb = new StringBuilder();

        String[] strArr = ipAddress.split("\\.");

        for (String s : strArr) {
            int i = Integer.parseInt(s);
            String binaryStr = Integer.toBinaryString(i);

            // NOTE: need to pad 0
            if (binaryStr.length() < 8) {
                for (int j = 0; j < 8 - binaryStr.length(); j++) {
                    sb.append("0");
                }
            }

            sb.append(binaryStr);
        }

        long num = Long.parseLong(sb.toString(), 2);

        return String.valueOf(num);
    }


    public static long convertIPAddressToNum2(String ip) {
        String[] iip = ip.split("\\.");
        Long ans = (long) 0;
        for (int i = 0; i < 4; i++) {
            ans = ans * 256 + Long.parseLong(iip[i]);
        }
        return ans;
    }

    public static String convertNumToIPAddress2(long num) {
        String[] ans = new String[4];
        for (int i = 3; i >= 0; i--) {
            ans[i] = Long.toString(num % 256);
            num = num / 256;
        }
        return String.join(".", ans);
    }
}
