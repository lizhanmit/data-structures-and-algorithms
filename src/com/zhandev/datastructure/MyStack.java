package com.zhandev.datastructure;

import java.util.Arrays;

public class MyStack {
	
	public static void main(String[] args) {
		MyStack theStack = new MyStack(5);
		
		System.out.println("Is empty: " + theStack.isEmpty());
		System.out.println("Is full: " + theStack.isFull());
		System.out.println("===");
		
		System.out.println(theStack.pop());
		System.out.println("===");
		
		theStack.push("a");
		theStack.push("b");
		theStack.push("c");
		theStack.push("d");
		theStack.push("e");
		System.out.println(Arrays.toString(theStack.getStackArray()));
		theStack.push("f");
		System.out.println("===");
		
		System.out.println(theStack.peek());
		System.out.println("===");
		
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
	}

	private String[] stackArray; 
	private int stackSize;
	private int top;
	
	public MyStack(int size) {
		stackSize = size; 
		stackArray = new String[size];
		top = -1;
	}
	
	public boolean isFull() {
		return top == stackSize - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(String newData) {
		if (isFull()) {
			System.out.println("The stack is full.");
		} else {
			top++; 
			stackArray[top] = newData;
		}
	}
	
	public String pop() { 
		if (isEmpty()) {
			System.out.println("The stack is empty.");
			return null;
		} else {
			return stackArray[top--];
		}
	}
	
	public String peek() {
		return stackArray[top];
	}

	public String[] getStackArray() {
		return stackArray;
	}
}
