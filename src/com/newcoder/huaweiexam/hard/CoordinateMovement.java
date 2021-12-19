package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 数据范围：每组输入的字符串长度满足  ，坐标保证满足  ，且数字部分仅含正数
 *
 * 注意请处理多组输入输出
 *
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 复制
 * 输出：
 * 10,-10
 * 复制
 * 示例2
 * 输入：
 * ABC;AKL;DA1;
 * 复制
 * 输出：
 * 0,0
 */
public class CoordinateMovement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String cmd = in.nextLine();

            //int[] coordinateArr = moveCoordinate(cmd);
            int[] coordinateArr = moveCoordinate2(cmd);

            System.out.println(coordinateArr[0] + "," + coordinateArr[1]);
        }
    }

    private static int[] moveCoordinate(String command) {
        int[] coordinateArr = new int[]{0, 0};

        String[] cmdArr = command.split(";");

        for (String cmd : cmdArr) {
            if (cmd.length() > 3 || cmd.length() < 2 || (cmd.charAt(0) != 'W' && cmd.charAt(0) != 'A' && cmd.charAt(0) != 'D' && cmd.charAt(0) != 'S')) {
                continue;
            }

            int step = 0;
            try {
                step = Integer.parseInt(cmd.substring(1));
            } catch (NumberFormatException e) {
                continue;
            }

            switch (cmd.charAt(0)) {
                case 'W': coordinateArr[1] += step; break;
                case 'S': coordinateArr[1] -= step; break;
                case 'A': coordinateArr[0] -= step; break;
                case 'D': coordinateArr[0] += step; break;
                default: break;
            }
        }

        return coordinateArr;
    }

    private static int[] moveCoordinate2(String command) {
        int x = 0;
        int y = 0;
        String[] cmdArr = command.split(";");
        for (String s : cmdArr) {
            // 不满足题目给定坐标规则
            if (!s.matches("[WASD][0-9]{1,2}")) {
                continue;
            }
            int val = Integer.valueOf(s.substring(1));
            switch (s.charAt(0)) {
                case 'W':
                    y += val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'A':
                    x -= val;
                    break;
                case 'D':
                    x += val;
                    break;
            }
        }

        return new int[]{x, y};
    }
}
