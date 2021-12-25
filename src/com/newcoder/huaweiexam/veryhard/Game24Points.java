package com.newcoder.huaweiexam.veryhard;

import java.util.*;

/**
 * 描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 * <p>
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * <p>
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 * <p>
 * 详细说明：
 * <p>
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过+ - * /四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2 A 9 A不能变为(2+1)*(9-1)=24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 * 7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，除数(即分母)的数字不可能为0
 * <p>
 * 数据范围：一行由4张牌组成的字符串
 * 输入描述：
 * 输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
 * <p>
 * 输出描述：
 * 输出怎么运算得到24，如果无法得出24，则输出“NONE”表示无解，如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 示例1
 * 输入：
 * A A A A
 * 复制
 * 输出：
 * NONE
 * 复制
 * 说明：
 * 不能实现
 * 示例2
 * 输入：
 * 4 2 K A
 * 复制
 * 输出：
 * K-A*4/2
 * 复制
 * 说明：
 * A+K*2-4也是一种答案，输出任意一种即可
 * 示例3
 * 输入：
 * B 5 joker 4
 * 复制
 * 输出：
 * ERROR
 * 复制
 * 说明：
 * 存在joker，输出ERROR
 * 示例4
 * 输入：
 * K Q 6 K
 * 复制
 * 输出：
 * NONE
 * 复制
 * 说明：
 * 按一般的计算规则来看，K+K-(Q/6)=24 或 K-((Q/6)-K)=24，但是因为这个题目的运算不许有括号，所以去掉括号后变为 K+K-Q/6=26-Q/6=14/6=2 或 K-Q/6-K=1/6-K=0-K=-13，其它情况也不能运算出24点，故不存在，输出NONE
 */
public class Game24Points {

    private static Map<String, Integer> map = new HashMap<String, Integer>() {{
        put("A", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("10", 10);
        put("J", 11);
        put("Q", 12);
        put("K", 13);
    }};
    private static List<List<String>> res = new ArrayList<>();//数字的全排列
    private static List<String> path = new ArrayList<>();
    private static List<List<String>> resType = new ArrayList<>();//运算符号的全排列，4选3
    private static List<String> pathType = new ArrayList<>();
    private static String[] type = {"+", "-", "*", "/"};//运算符号
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        flag = false;
        String[] game = in.nextLine().split("\\s");
        boolean[] visited = new boolean[game.length];
        if (containsJoker(game)) {
            System.out.println("ERROR");
        } else {
            Arrays.sort(game);
            dfs(game, visited);
            dfsType(type);
            for (List<String> s1 : res) {
                for (List<String> s2 : resType) {
                    if (cal(s1, s2) == 24) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < s1.size(); k++) {
                            sb.append(s1.get(k));
                            if (k < s2.size()) {
                                sb.append(s2.get(k));
                            }
                        }
                        flag = true;//有解
                        System.out.println(sb.toString());//输出一种情况即可
                        break;
                    }
                }
                if (flag) {//有解直接退出
                    break;
                }
            }
            if (!flag) {//无解
                System.out.println("NONE");
            }
        }
    }

    public static boolean containsJoker(String[] game) {
        for (String s : game) {
            if (s.equals("JOKER") || s.equals("joker")) {
                return true;
            }
        }
        return false;
    }

    //搜索所有数字的排列情况，剪枝去重
    public static void dfs(String[] game, boolean[] visited) {
        //终止条件
        if (path.size() == game.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < game.length; i++) {
            if (i > 0 && game[i] == game[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                path.add(game[i]);
                dfs(game, visited);
                path.remove(path.size() - 1);//回溯
                visited[i] = false;
            }
        }
    }

    //搜索所有运算符号的排列，4选3，允许重复
    public static void dfsType(String[] type) {
        //终止条件
        if (pathType.size() == 3) {
            resType.add(new ArrayList<>(pathType));
            return;
        }
        for (int i = 0; i < type.length; i++) {
            pathType.add(type[i]);
            dfsType(type);
            pathType.remove(pathType.size() - 1);//回溯
        }
    }

    //计算一个算式的结果，根据题意按从左到右计算即可
    public static int cal(List<String> listNum, List<String> listType) {
        int res = map.get(listNum.get(0));//初始化为第一个数
        for (int i = 0; i < listType.size(); i++) {
            switch (listType.get(i)) {
                case "+":
                    res += map.get(listNum.get(i + 1));
                    break;
                case "-":
                    res -= map.get(listNum.get(i + 1));
                    break;
                case "*":
                    res *= map.get(listNum.get(i + 1));
                    break;
                case "/":
                    res /= map.get(listNum.get(i + 1));
                    break;
            }
        }
        return res;
    }
}
