package com.newcoder.huaweiexam;

import java.util.Scanner;

public class LengthOfStringLastWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		int length = lengthOfStringLastWord(input);
		
		System.out.println(length);
	}
	
	private static int lengthOfStringLastWord(String str) {
		String[] strArr = str.split("\\s+");
		
		return strArr[strArr.length - 1].length();
	}
}
