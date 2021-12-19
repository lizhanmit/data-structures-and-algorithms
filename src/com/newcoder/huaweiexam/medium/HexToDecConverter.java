package com.newcoder.huaweiexam.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在
 *
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 */
public class HexToDecConverter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String hexStr = in.nextLine();

            //String decStr = convertHexToDec(hexStr);
            String decStr = convertHexToDec2(hexStr);

            System.out.println(decStr);
        }
    }

    private static String convertHexToDec(String hexStr) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        int sum = 0;
        int temp = 0;

        String s = hexStr.substring(2);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                temp = map.get(s.charAt(i));
            } else {
                temp = Integer.parseInt(String.valueOf(s.charAt(i)));
            }

            sum += temp * (int) Math.pow(16, s.length() - 1 - i);
        }

        return String.valueOf(sum);
    }

    // use Integer.parseInt(String s, int radix)
    private static String convertHexToDec2(String hexStr) {
        return String.valueOf(Integer.parseInt(hexStr.substring(2), 16));
    }
}
