package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Find the min element of an ascending rotated int array.
 * Array: {1,2,3,4,5}
 * Rotated array: {3,4,5,1,2}
 */
public class Q11 {

	/*
	 * Use binary search.
	 * Time: O(logn)
	 * 
	 * Special case 1: 
	 * An array itself is also a rotated array - rotate 0.
	 * 
	 * Special case 2: 
	 * For {0,1,1,1,1} and {1,0,1,1,1}, 
	 * rotatedArr[low], rotatedArr[high] and rotatedArr[mid] are the same,
	 * binary search does not work here,
	 * use loop.
	 */
	private static int minOfRotatedArray(int[] rotatedArr) throws Exception {
		if (rotatedArr == null || rotatedArr.length == 0) {
			throw new Exception("Invalid rotated array.");
		}
		
		int low = 0;
		int high = rotatedArr.length - 1;
		int mid = 0;
		
		// deal with special case 1
		if (rotatedArr[low] < rotatedArr[high]) {
			return rotatedArr[low];
		}
		
		while (high - low > 1) {
			mid = (low + high) / 2;
			
			// deal with special case 2
			if (rotatedArr[mid] == rotatedArr[low] && rotatedArr[mid] == rotatedArr[high]) {
				for (int i = low; i < high; i++) {
					if (rotatedArr[i] > rotatedArr[i + 1]) {
						return rotatedArr[i + 1];
					}
				}
			}
			
			if (rotatedArr[mid] >= rotatedArr[low]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return rotatedArr[high];
	}
	
	@Test
	public void testMinOfRotatedArray() throws Exception {
		int[] rotatedArr = {3,4,5,1,2};
		assertEquals(minOfRotatedArray(rotatedArr), 1);
		
		int[] rotatedArr2 = {1,2,3,4,5};
		assertEquals(minOfRotatedArray(rotatedArr2), 1);
		
		int[] rotatedArr3 = {1,0,1,1,1};
		assertEquals(minOfRotatedArray(rotatedArr3), 0);
	}
}
