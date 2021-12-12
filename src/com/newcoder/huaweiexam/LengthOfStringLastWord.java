package com.newcoder.huaweiexam;

import java.util.Scanner;

public class LengthOfStringLastWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		int length = lengthOfStringLastWord(input);
		
		System.out.println(length);
	}

	// O(n) space because of an extra string array
    // O(n) time
	private static int lengthOfStringLastWord(String str) {
		String[] strArr = str.split("\\s+");
		
		return strArr[strArr.length - 1].length();
	}

	// this one is better as O(1) space
    // O(n) time
    private static int lengthOfStringLastWord2(String str) {
	    int index = -1;  // this must be -1
        for (int i = str.length() - 1; i >= 0 ; i--) {
            if (str.charAt(i) == ' ') {
                index = i;
                break;
            }
        }

        return str.length() - 1 - index;
    }

}
