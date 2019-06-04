package com.zhandev.java.arraysClass;

import java.util.Arrays;

public class TwoArraysComparison {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		// print "not same" because arr1 and arr2 refers to different objects
		if (arr1 == arr2) {  // same as arr1.equals(arr2)
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		// print "same" because it compares the array contents
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		
		Object[] o1 = {arr1};
		Object[] o2 = {arr2};
		
		// print "not same" because the array content is another array or reference type 
		// should use deep comparison here
		if (Arrays.equals(o1, o2)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		// print "same"
		// deep comparison
		if (Arrays.deepEquals(o1, o2)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		// deepEquals() is also applicable for multinest
	}
}
