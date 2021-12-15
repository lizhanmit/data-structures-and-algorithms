package com.newcoder.huaweiexam.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\\ d:\\e，
 *
 * 各个参数如下：
 *
 * 参数1：命令字xcopy
 *
 * 参数2：字符串/s
 *
 * 参数3：字符串c:\\
 *
 * 参数4: 字符串d:\\e
 *
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 *
 * 解析规则：
 *
 * 1.参数分隔符为空格
 * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\\program files，而不是C:\\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
 * 3.参数不定长
 *
 * 4.输入由用例保证，不会出现不符合要求的输入
 * 数据范围：字符串长度：
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一行字符串，可以有空格
 *
 * 输出描述：
 * 输出参数个数，分解后的参数，每个参数都独占一行
 */
public class ParseArgument {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        parseArg(input);
        //parseArg2(input);
    }

    private static void parseArg(String input) {
        boolean quoteFlag = false;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String[] strArr = input.split(" ");
        for (String s : strArr) {
            if (s.startsWith("\"") && s.endsWith("\"")) {
                list.add(s.substring(1, s.length() - 1));
            } else if (s.startsWith("\"")) {
                quoteFlag = true;
                sb.append(s.substring(1)).append(" ");
            } else if (s.endsWith("\"")) {
                quoteFlag = false;
                sb.append(s.substring(0, s.length() - 1));
                list.add(sb.toString());
                sb = new StringBuilder();
            } else if (quoteFlag == true) {
                sb.append(s).append(" ");
            } else {
                list.add(s);
            }
        }

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void parseArg2(String input) {
        boolean quotaFlag = false;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '"') {
                quotaFlag = quotaFlag ? false : true;
                continue;
            }

            if (c == ' ' && !quotaFlag) {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        list.add(sb.toString());

        System.out.println(list.size());

        list.stream().forEach(System.out::println);
    }
}