package book.DSAInJava.queue;

/**
 * wraparound configuration
 * In practice, better than LinkedList implementation.
 */
public class MyQueueUsingCircularArray<E> implements MyQueueInterface<E> {

	private E data[];
	private int front; // index of the first element
	private int size;
	
	public MyQueueUsingCircularArray(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
		front = 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public void enqueue(E e) {
		if (size == data.length) {
			throw new IllegalStateException("The queue is full.");
		}
		
		int avail = (front + size) % data.length;
		data[avail] = e;
		size++;
	}
	
	@Override
	public E dequeue() {
		if (size == 0) {
			return null;
		}
		
		E answer = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return answer;
	}
	
	@Override
	public E first() {
		if (size == 0) {
			return null;
		}
		
		return data[front];
	}
	
}
