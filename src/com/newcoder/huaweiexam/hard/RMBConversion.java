package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 *
 *
 * 本题含有多组样例输入。
 *
 * 输入描述：
 * 输入一个double数
 *
 * 输出描述：
 * 输出人民币格式
 *
 * 示例1
 * 输入：
 * 151121.15
 * 10012.02
 * 13.64
 * 0.85
 * 复制
 * 输出：
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 * 人民币壹万零拾贰元贰分
 * 人民币拾叁元陆角肆分
 * 人民币捌角伍分
 * 复制
 * 示例2
 * 输入：
 * 1010.00
 * 110.00
 * 复制
 * 输出：
 * 人民币壹仟零拾元整
 * 人民币壹佰拾元整
 */
public class RMBConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextDouble()) {
            double rmb = in.nextDouble();
            String chineseCapital = convertRMBNumberToChineseCapital(rmb);
            System.out.println(chineseCapital);
        }
    }

    private static String convertRMBNumberToChineseCapital(double rmb) {
        String str = String.format("%.2f", rmb) + "";
        String[] zeroToNine = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] unit = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟", "万"};
        String[] tmp = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = tmp[0].length() - 1; i < tmp[0].length(); i++, j--) {
            if (tmp[0].charAt(i) != '0') {
                if (!(tmp[0].charAt(i) == '1' && "拾".equals(unit[j])))
                    sb.append(zeroToNine[tmp[0].charAt(i) - '0']);
                sb.append(unit[j]);
            } else {
                while (i < tmp[0].length() && tmp[0].charAt(i) == '0') {
                    if ("万".equals(unit[j]) || "亿".equals(unit[j])) sb.append(unit[j]);
                    i++;
                    j--;
                }
                if (i == tmp[0].length()) break;
                if (j % 4 != 3) sb.append("零");
                i--;
                j++;
            }
        }
        if (sb.length() != 0) {
            if ("00".equals(tmp[1])) sb.append("元整");
            else sb.append("元");
        }
        if (!"00".equals(tmp[1])) {
            for (int i = 0; i < 2; i++) {
                if (tmp[1].charAt(i) != '0' && i == 0)
                    sb.append(zeroToNine[tmp[1].charAt(i) - '0']).append("角");
                if (tmp[1].charAt(i) != '0' && i == 1)
                    sb.append(zeroToNine[tmp[1].charAt(i) - '0']).append("分");
            }
        }

        return "人民币" + sb.toString();
    }
}
