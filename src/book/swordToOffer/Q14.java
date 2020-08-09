package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Cutting rope problem.
 */
public class Q14 {

	/*
	 * Using dynamic programming method.
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	private static int maxProductDynamicProgMethod(int lengthOfRope) {
		if (lengthOfRope < 2) {
			return 0;
		}
		
		if (lengthOfRope == 2) {
			return 1;
		}
		
		if (lengthOfRope == 3) {
			return 2;
		}
		
		int[] product = new int[lengthOfRope + 1];
		// these three values are not max product for their corresponding length of rope
		// they are just used for later calculation
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		
		int max = 0;
		// loop every sub segment of the rope
		for (int i = 4; i <= lengthOfRope; i++) {
			max = 0;
			// calculate each segment
			for (int j = 1; j <= lengthOfRope / 2; j++) {
				int prod = product[j] * product[i - j];
				if (prod > max) {
					max = prod;
				}
			}
			product[i] = max;
		}
		
		return product[lengthOfRope];
		 
	}
	
	/*
	 * Using greedy algorithm idea.
	 * Time: O(1)
	 * Space: O(1)
	 */
	private static int maxProductGreedyAlgoMethod(int lengthOfRope) {
		if (lengthOfRope < 2) {
			return 0;
		}
		
		if (lengthOfRope == 2) {
			return 1;
		}
		
		if (lengthOfRope == 3) {
			return 2;
		}
		
		int numOf3 = lengthOfRope / 3;
		
		// if the length of the last piece is 4
		// do not cut it as 3 and 1
		// instead, 2 and 2
		if (lengthOfRope - numOf3 * 3 == 1) {
			numOf3--;
		}
		
		int numOf2 = (lengthOfRope - numOf3 * 3) / 2;
		
		// cast to int because the type of pow() return value is double 
		return (int) Math.pow(3, numOf3) * (int) Math.pow(2, numOf2);
	}
	
	@Test
	public void testMaxProductDynamicProgMethod() {
		assertEquals(maxProductDynamicProgMethod(7), 12);
		assertEquals(maxProductDynamicProgMethod(8), 18);
	}
	
	@Test
	public void testMaxProductGreedyAlgoMethod() {
		assertEquals(maxProductGreedyAlgoMethod(7), 12);
		assertEquals(maxProductGreedyAlgoMethod(8), 18);
	}
}
