package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Use two queues to implement a stack with pop() and push() method.
 */
public class Q9b {

	private static class StackUsingTwoQueues<E> {
		// if queue1 is not empty, queue2 must be empty, vice versa
		Queue<E> queue1;
		Queue<E> queue2;
		
		public StackUsingTwoQueues() {
			this.queue1 = new LinkedList<>();
			this.queue2 = new LinkedList<>();
		}
		
		public E push(E e) {
			if (queue1.isEmpty() && queue2.isEmpty()) {
				queue1.offer(e);
			} else if (!queue1.isEmpty()) {
				queue1.offer(e);
			} else {
				queue2.offer(e);
			}
			return e;
		}
		
		public E pop() {
			if (queue1.isEmpty() && queue2.isEmpty()) {
				return null;
			}
			
			if (!queue1.isEmpty()) {
				while (queue1.size() > 1) {
					queue2.offer(queue1.poll());
				}
				return queue1.poll();
			} else {
				while (queue2.size() > 1) {
					queue1.offer(queue2.poll());
				}
				return queue2.poll();
			}
		}
	}
	
	@Test
	public void test() {
		StackUsingTwoQueues<Integer> stack = new StackUsingTwoQueues<>();
		assertEquals(stack.pop(), null);
		assertEquals(stack.push(1), new Integer(1));
		assertEquals(stack.push(2), new Integer(2));
		assertEquals(stack.push(3), new Integer(3));
		assertEquals(stack.pop(), new Integer(3));
		assertEquals(stack.pop(), new Integer(2));
		assertEquals(stack.pop(), new Integer(1));
		assertEquals(stack.pop(), null);
	}
}
