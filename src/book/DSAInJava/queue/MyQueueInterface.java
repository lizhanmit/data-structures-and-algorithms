package book.DSAInJava.queue;

public interface MyQueueInterface<E> {

	int size();
	
	boolean isEmpty();
	
	void enqueue(E e);
	
	E dequeue();
	
	E first();
}
