package leetcode.explore.stack;

public class MyStack {

	private int[] data;
	
	private int top;
	
	public MyStack(int k) {
		data = new int[k];
		top = -1;
	}
	
	public boolean pop() {
		if (isEmpty()) return false;
		
		top--;
		return true;
	}
	
	public boolean push(int value) {
		if (isFull()) return false; 
		
		data[++top] = value;
		return true;
	}
	
	public int peek() throws Exception {
		if (isEmpty()) throw new Exception();
		
		return data[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top + 1 == data.length;
	}
}
