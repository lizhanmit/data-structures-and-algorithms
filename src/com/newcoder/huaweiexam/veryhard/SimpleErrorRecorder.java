package com.newcoder.huaweiexam.veryhard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 * 处理：
 *
 *
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 *
 * 数据范围：错误记录数量满足  ，每条记录长度满足
 * 输入描述：
 * 每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述：
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入：
 * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 * E:\je\rzuwnjvnuz 633
 * C:\km\tgjwpb\gy\atl 637
 * F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
 * E:\ns\mfwj\wqkoki\eez 648
 * D:\cfmwafhhgeyawnool 649
 * E:\czt\opwip\osnll\c 637
 * G:\nt\f 633
 * F:\fop\ywzqaop 631
 * F:\yay\jc\ywzqaop 631
 * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 * 复制
 * 输出：
 * rzuwnjvnuz 633 1
 * atl 637 1
 * rwyfvzsopsuiqjnr 647 1
 * eez 648 1
 * fmwafhhgeyawnool 649 1
 * c 637 1
 * f 633 1
 * ywzqaop 631 2
 * 复制
 * 说明：
 * 由于D:\cfmwafhhgeyawnool 649的文件名长度超过了16个字符，达到了17，所以第一个字符'c'应该被忽略。
 * 记录F:\fop\ywzqaop 631和F:\yay\jc\ywzqaop 631由于文件名和行号相同，因此被视为同一个错误记录，哪怕它们的路径是不同的。
 * 由于循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准，所以D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645不会被记录。
 */
public class SimpleErrorRecorder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();

        while (in.hasNextLine()) {
            String[] strArr = in.nextLine().split(" ");

            String fileName = strArr[0].substring(strArr[0].lastIndexOf("\\") + 1);
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }

            String record = fileName + " " + strArr[1];
            map.put(record, map.getOrDefault(record, 0) + 1);
        }

        if (map.size() <= 8) {
            map.forEach((k, v) -> System.out.println(k + " " + v));
        } else {
            Object[] keys = map.keySet().toArray();
            for (int i = keys.length - 8; i < keys.length; i++) {
                System.out.println(keys[i] + " " + map.get(keys[i]));
            }
        }
    }
}
