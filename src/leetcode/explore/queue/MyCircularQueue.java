package leetcode.explore.queue;

public class MyCircularQueue {

	private int[] data;
	
	private int front, rear;
	
	public MyCircularQueue(int k) {
		data = new int[k];
		front = -1;
		rear = -1;
	}
	
	
	public boolean enqueue(int value) {
		if (isFull()) return false;
		
		if (isEmpty()) {
			front = 0;
		}
		
		rear = (rear + 1) % data.length;
		data[rear] = value;
		
		return true;
	}
	
	public boolean dequeue() {
		if (isEmpty()) return false; 
		
		// It is also special when there is only one element in the array.
		if (front == rear) {
			front = -1;
			rear = -1;
			return true;
		}
		
		front = (front + 1) % data.length;
		return true;
	}
	
	public int getFront() {
		if (isEmpty()) return -1;
		
		return data[front];
	}
	
	public int getRear() {
		if (isEmpty()) return -1;
		
		return data[rear];
	}

	// The essence is as long as the array is empty, set front as -1.
	public boolean isEmpty() {
		return front == -1;
	}
	
	// The essence is to check if rear move one more step will meet front.
	public boolean isFull() {
		return (rear + 1) % data.length == front;
	}
	
}
