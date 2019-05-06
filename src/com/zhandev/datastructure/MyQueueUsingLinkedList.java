package com.zhandev.datastructure;

import java.util.LinkedList;

/**
 * more expensive than array-based implementation
 */
public class MyQueueUsingLinkedList<E> {

	private LinkedList<E> linkedList = new LinkedList<>();
	
	public int size() {
		return linkedList.size();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	public void enqueue(E element) {
		linkedList.add(element);  // be equivalent to addLast()
	}
	
	public E dequeue() {
		return linkedList.removeFirst();
	}
	
	public E peek() {
		return linkedList.getFirst();
	}
}
