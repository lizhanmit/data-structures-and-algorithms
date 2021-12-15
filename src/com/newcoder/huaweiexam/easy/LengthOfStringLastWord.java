package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * （注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class LengthOfStringLastWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		//int length = lengthOfStringLastWord(input);
		int length = lengthOfStringLastWord2(input);

		System.out.println(length);
	}

	// this one is better as O(1) space
	// O(n) time
	private static int lengthOfStringLastWord2(String str) {
		int index = -1;  // this must be -1
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				index = i;
				break;
			}
		}

		return str.length() - 1 - index;
	}

	// O(n) space because of an extra string array
    // O(n) time
	private static int lengthOfStringLastWord(String str) {
		String[] strArr = str.split("\\s+");
		
		return strArr[strArr.length - 1].length();
	}
}
