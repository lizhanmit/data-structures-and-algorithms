package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 *
 * 具体规则如下:
 * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
 * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
 * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
 * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
 *
 * 下面再看几个数字例句：
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 *
 * 说明：
 * 数字为正整数，不考虑小数，转化结果为英文小写；
 * 保证输入的数据合法
 * 关键字提示：and，billion，million，thousand，hundred。
 *
 * 数据范围：
 *
 * 本题含有多组输入数据。
 *
 * 输入描述：
 * 输入多行long型整数
 *
 * 输出描述：
 * 输出相应的英文写法
 *
 * 示例1
 * 输入：
 * 22
 * 100
 * 145
 * 1234
 * 8088
 * 486669
 * 1652510
 * 复制
 * 输出：
 * twenty two
 * one hundred
 * one hundred and forty five
 * one thousand two hundred and thirty four
 * eight thousand eighty eight
 * four hundred and eighty six thousand six hundred and sixty nine
 * one million six hundred and fifty two thousand five hundred and ten
 */
public class ConvertNumberToEnglish {

    private static String[] zeroToNine = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] tenToNineteen = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] dozens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] unit = {"hundred", "thousand", "million", "billion"};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLong()) {
            long num = in.nextLong();
            String english = convertNumberToEnglish(num);
            System.out.println(english);
        }
    }

    // use recursion
    private static String convertNumberToEnglish(long num) {
        //0-9
        if (num >= 0 && num <= 9) {
            return zeroToNine[(int) num];
        }
        //两位数10-19
        if (num >= 10 && num <= 19) {
            return tenToNineteen[(int) (num % 10)];
        }
        //两位数20-99
        if (num >= 20 && num <= 99) {
            //个位是0
            if (num % 10 == 0) {
                return dozens[(int) (num / 10 - 2)];
            } else {
                return dozens[(int) (num / 10 - 2)] + " " + zeroToNine[(int) (num % 10)];
            }
        }
        //三位数
        if (num >= 100 && num <= 999) {
            //十位个位为0
            if (num % 100 == 0) {
                return zeroToNine[(int) (num / 100)] + " " + unit[0];
            } else {
                return zeroToNine[(int) (num / 100)] + " " + unit[0] + " and " + convertNumberToEnglish(num % 100);
            }
        }
        //四到六位数
        if (num >= 1000 && num <= 999999) {
            return convertNumberToEnglish(num / 1000) + " " + unit[1] + " " + convertNumberToEnglish(num % 1000);
        }
        //七到九位
        if (num >= 1000000 && num <= 999999999) {
            return convertNumberToEnglish(num / 1000000) + " " + unit[2] + " " + convertNumberToEnglish(num % 1000000);
        }
        //十到十二位
        return convertNumberToEnglish(num / 1000000000) + " " + unit[3] + " " + convertNumberToEnglish(num % 1000000000);
    }
}
