package com.zhandev.datastructure;

import java.util.LinkedList;

public class MyStackUsingLinkedList<E> {

	private LinkedList<E> linkedList = new LinkedList<>();
	
	public int size() {
		return linkedList.size();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	public void push(E element) {
		linkedList.addFirst(element);
	}
	
	public E pop() {
		return linkedList.removeFirst();
	}
	
	public E top() {
		return linkedList.getFirst();
	}
}

