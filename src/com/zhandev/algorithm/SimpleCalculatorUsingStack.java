package com.zhandev.algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimpleCalculatorUsingStack {

	
	public static int calculate(List<String> suffixList) throws Exception {
		if (suffixList == null || suffixList.isEmpty()) {
			throw new Exception("suffixList is null or empty");
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for (String s : suffixList) {
			if (!s.equals("+") && !s.equals("-")) {
				stack.push(Integer.parseInt(s));
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch (s) {
				case "+":
					stack.push(num1 + num2);
					break;

				case "-":
					stack.push(num1 - num2);
					break;
				}
			}
		}
		return stack.pop();
	}
	
	public static ArrayList<String> infixToSuffix(List<String> infixList) throws Exception {
		if (infixList == null || infixList.isEmpty()) {
			throw new Exception("infixList is null or empty");
		}
		
		Stack<String> stack = new Stack<>();
		ArrayList<String> suffixList = new ArrayList<>();
		
		for (String s : infixList) {
			if (!s.equals("+") && !s.equals("-")) {
				suffixList.add(s);
			} else if (stack.isEmpty()) {
				stack.push(s);
			} else {
				suffixList.add(stack.pop());
				stack.push(s);
			}
		}
		while (!stack.isEmpty()) {
			suffixList.add(stack.pop());
		}
		
		return suffixList;
	}
	
	public static void main(String[] args) throws Exception {
		String s = "-2,+,2,+,3,-,6,+,4";
		List<String> infixList = new ArrayList<>(Arrays.asList(s.split(",")));
		List<String> suffixList = infixToSuffix(infixList);
		System.out.println(suffixList.toString());
		System.out.println(calculate(suffixList));
	}
}
