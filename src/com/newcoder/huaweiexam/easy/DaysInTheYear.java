package com.newcoder.huaweiexam.easy;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 描述
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一行，每行空格分割，分别是年，月，日
 *
 * 输出描述：
 * 输出是这一年的第几天
 */
public class DaysInTheYear {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();

        int daysInTheYear = daysInTheYear(year, month, day);

        System.out.println(daysInTheYear);
    }

    // use Calendar API
    private static int daysInTheYear(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);  // NOTE: month starts from 0, so need to -1
        return cal.get(Calendar.DAY_OF_YEAR);
    }
}
