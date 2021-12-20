package com.newcoder.huaweiexam.hard;

import java.util.*;

/**
 * 描述
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 *
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 *
 * 请注意本题有多组输入用例。
 *
 * 数据范围： ，输入的整数大小满足
 * 输入描述：
 * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限
 *
 * 输出描述：
 * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 *
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 *
 * 按R<i>从小到大的顺序:
 *
 * (1)先输出R<i>；
 *
 * (2)再输出满足条件的I的个数；
 *
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 *
 * (4)最后再输出I。
 *
 * 附加条件：
 *
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
 *
 * (2)如果没有满足条件的I，对应的R<i>不用输出
 *
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 *
 *
 *
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 *
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 *
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 *
 * 说明：
 *
 * 30----后续有30个整数
 *
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
 *
 * 6--- 存在6个包含3的I
 *
 * 0--- 123所在的原序号为0
 *
 * 123--- 123包含3，满足条件
 *
 * 示例1
 * 输入：
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 复制
 * 输出：
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 */
public class ClassifiedDataProcessing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] r = new String[n];
            for (int i = 0; i < n; i++) {
                r[i] = sc.next();
            }
            int m = sc.nextInt();
            Set<Integer> si = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                si.add(sc.nextInt());
            }
            List<Integer> al = new ArrayList();
            List<Integer> rt = new ArrayList();
            for (int numi : si) {
                int count = 0;
                for (int i = 0; i < r.length; i++) {
                    if (r[i].contains(String.valueOf(numi))) {
                        count++;
                        al.add(i);
                        al.add(Integer.valueOf(r[i]));
                    }
                }
                if (count > 0) {
                    rt.add(numi);
                    rt.add(count);
                    rt.addAll(al);
                }
                al.clear();
            }
            System.out.print(rt.size() + " ");
            for (Integer i : rt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // another approach
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            if (str.equals("")) continue;
            //需要过了的I
            String[] I = str.split(" ");
            // R
            String[] temp = br.readLine().split(" ");
            long[] R = new long[Integer.parseInt(temp[0])];
            for (int i = 0; i < R.length; i++) R[i] = Long.parseLong(temp[i + 1]);
            //先对R进行排序 然后在依次遍历
            Arrays.sort(R);
            //最终的结果记录
            StringBuilder result = new StringBuilder();
            int count = 0;
            for (int i = 0; i < R.length; i++) {
                //当R中的值相等的时候 只保留第一个出现的
                if (i > 0 && R[i] == R[i - 1]) continue;
                //需要进行匹配的字符
                String pattern = R[i] + "";
                int num = 0;
                StringBuilder index = new StringBuilder();
                for (int j = 1; j < I.length; j++) {
                    //说明出现了 找到位置
                    if (I[j].indexOf(pattern) != -1) {
                        num++;
                        index.append(" ").append(j - 1).append(" ").append(I[j]);
                    }
                }
                //说明存在跟此时R[i]匹配的I
                if (num > 0) {
                    result.append(" ").append(R[i]).append(" ").append(num).append(index);
                    count += num * 2 + 2;
                }
            }
            System.out.println(count + result.toString());
        }
    }

    */
}

