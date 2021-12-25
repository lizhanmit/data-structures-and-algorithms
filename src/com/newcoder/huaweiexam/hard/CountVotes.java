package com.newcoder.huaweiexam.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 *
 * 数据范围：每组输入中候选人数量满足  ，总票数量满足
 * 输入描述：
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述：
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
 *
 * 示例1
 * 输入：
 * 4
 * A B C D
 * 8
 * A D E CF A GG A B
 * 复制
 * 输出：
 * A : 3
 * B : 1
 * C : 0
 * D : 1
 * Invalid : 3
 */
public class CountVotes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int numOfCandidates = in.nextInt();
            String[] candidates = new String[numOfCandidates];
            for (int i = 0; i < numOfCandidates; i++) {
                candidates[i] = in.next();
            }

            int numOfVotes = in.nextInt();
            String[] votes = new String[numOfVotes];
            for (int i = 0; i < numOfVotes; i++) {
                votes[i] = in.next();
            }

            printVoteResult(candidates, votes);
        }
    }

    private static void printVoteResult(String[] candidates, String[] votes) {
        Map<String, Integer> resultMap = new HashMap<>(candidates.length);
        for (String c : candidates) {
            resultMap.put(c, 0);
        }

        int numOfInvalidVotes = 0;

        for (String v : votes) {
            if (resultMap.containsKey(v)) {
                resultMap.put(v, resultMap.get(v) + 1);
            } else {
                numOfInvalidVotes++;
            }
        }

        Arrays.stream(candidates).forEach(c -> System.out.println(c + " : " + resultMap.get(c)));
        System.out.println("Invalid : " + numOfInvalidVotes);
    }
}
