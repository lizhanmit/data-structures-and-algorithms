package book.swordToOffer;

import java.util.Stack;

/**
 * Use two stacks to implement a queue with appendTail() and deleteHead() method.
 */
public class Q9a {
	
	private static class QueueUsingTwoStacks<E> {
		Stack<E> stack1;  // used for enqueue
		Stack<E> stack2;  // used for dequeue
		
		public QueueUsingTwoStacks() {
			this.stack1 = new Stack<>();
			this.stack2 = new Stack<>();
		}
		
		public void appendTail(E e) {
			stack1.push(e);
		}
		
		public E deleteHead() {
			if (stack2.isEmpty()) {
				if (stack1.isEmpty()) {
					return null;
				}
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			
			return stack2.pop();
		}
	}
}
