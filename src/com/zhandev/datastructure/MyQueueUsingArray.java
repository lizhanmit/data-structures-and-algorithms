package com.zhandev.datastructure;

import java.util.Arrays;

public class MyQueueUsingArray {

	public static void main(String[] args) {
		MyQueueUsingArray myQueue = new MyQueueUsingArray(5);
		
		System.out.println("Is empty: " + myQueue.isEmpty());
		System.out.println("Is full: " + myQueue.isFull());
		System.out.println("===");
		
		System.out.println(myQueue.remove());
		System.out.println("===");
		
		myQueue.insert("a");
		myQueue.insert("b");
		myQueue.insert("c");
		myQueue.insert("d");
		myQueue.insert("e");
		System.out.println(Arrays.toString(myQueue.getQueueArray()));
		myQueue.insert("f");
		System.out.println("===");
		
		System.out.println(myQueue.peek());
		System.out.println("===");
		
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		
	}

	private String[] queueArray; 
	private int queueSize; 
	private int numOfElements; 
	private int front; 
	private int rear; 

	public MyQueueUsingArray(int size) {
		queueSize = size; 
		queueArray = new String[size];
		numOfElements = 0;
		front = 0; 
		rear = -1;
	}
	
	public void insert(String newData) {
		if (isFull()) {
			System.out.println("The queue is full.");
		} else {
			queueArray[++rear] = newData; 
			numOfElements++;
		}
	}
	
	public String remove() {
		if (isEmpty()) {
			System.out.println("The queue is empty.");
			return null;
		} else {
			numOfElements--;
			return queueArray[front++];
		}
	}
	
	public String peek() {
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return numOfElements == 0;
	}
	
	public boolean isFull() {
		return numOfElements == queueSize;
	}

	public String[] getQueueArray() {
		return queueArray;
	}
}
