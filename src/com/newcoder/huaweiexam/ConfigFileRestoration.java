package com.newcoder.huaweiexam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 有6条配置命令，它们执行的结果分别是：
 * <p>
 * 命   令	执   行
 * reset	reset what
 * reset board	board fault
 * board add	where to add
 * board delete	no board at all
 * reboot backplane	impossible
 * backplane abort	install first
 * he he	unknown command
 * 注意：he he不是命令。
 * <p>
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * <p>
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 * <p>
 * 注意：有多组输入。
 * 数据范围：数据组数：，字符串长度
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 多行字符串，每行字符串一条命令
 * <p>
 * 输出描述：
 * 执行结果，每条命令输出一行
 */
public class ConfigFileRestoration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            String value = commandValue(input);
            System.out.println(value);
        }
    }

    public static String commandValue(String s) {
        String[] strings = {"reset", "reset board", "board add", "board delete", "reboot backplane", "backplane abort"};

        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add ");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        String ERROR = "unknown command";

        String[] inputArr = s.split(" ");
        // 输入的命令长度为1
        if (inputArr.length == 1) {
            String input = inputArr[0];
            String cmd = strings[0].substring(0, input.length());
            if (cmd.equals(input)) {
                return "reset what";
            } else {
                return ERROR;
            }
        } else {
            // 匹配成功的命令数量
            int countOfMatch = 0;
            // 匹配成功后在map的key
            String key = "";
            // 穷举二字串的命令
            for (int i = 1; i < strings.length; i++) {
                String input1 = inputArr[0], input2 = inputArr[1];
                String command = strings[i];
                String[] cmd = command.split(" ");
                if (cmd.length == 2) {
                    String cmd1 = cmd[0], cmd2 = cmd[1];
                    // 输入的命令长度天长，不匹配该命令
                    if (cmd1.length() < input1.length() || cmd2.length() < input2.length()) {
                        continue;
                    }
                    String s1 = cmd1.substring(0, input1.length());
                    String s2 = cmd2.substring(0, input2.length());
                    // 匹配前缀
                    if (s1.equals(input1) && s2.equals(input2)) {
                        // 匹配成功后的
                        key = command;
                        // 统计匹配成功的次数
                        countOfMatch++;
                    }
                }
            }
            // 只能匹配成功一个
            if (countOfMatch == 1) {
                return map.get(key);
            } else {
                return ERROR;
            }
        }
    }
}
