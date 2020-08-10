package book.DSAInJava.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearch {

	/**
	 * O(log n) time
	 * 
	 * @param data
	 * @param target
	 * @param fromIndex
	 * @param toIndex
	 * @return  index of the target
	 */
	public static int binarySearchRecursively(int[] data, int target, int fromIndex, int toIndex) {
		if (data == null || data.length == 0 || data[0] > target || data[data.length - 1] < target || fromIndex > toIndex) {
			return -1;  // if cannot find the target, return -1 
		}
		
		// if the values of fromIndex and toIndex are very big, may overflow
		//int mid = (fromIndex + toIndex) / 2;
		// better way 
		//int mid = (toIndex - fromIndex) / 2 + fromIndex;
		// mathematically, >> 1 is the same as / 2, but better performance 
		// better way
		int mid = ((toIndex - fromIndex) >> 1) + fromIndex;
		
		if (target == data[mid]) {
			return mid;
		}
		
		if (target < data[mid]) {
			return binarySearchRecursively(data, target, fromIndex, mid - 1);
		} 
		
		return binarySearchRecursively(data, target, mid + 1, toIndex);
	}
	
	/**
	 * O(log n) time
	 * 
	 * @param data
	 * @param target
	 * @return  index of the target
	 */
	public static int binarySearchLoop(int[] data, int target) {
		if (data == null || data.length == 0 || data[0] > target || data[data.length - 1] < target) {
			return -1;
		}
		
		int fromIndex = 0;
		int toIndex = data.length - 1;
		int mid = 0;
		
		while (fromIndex <= toIndex) {
			// if the values of fromIndex and toIndex are very big, may overflow
			//mid = (fromIndex + toIndex) / 2;
			// better way 
			//mid = (toIndex - fromIndex) / 2 + fromIndex;
			// mathematically, >> 1 is the same as / 2, but better performance 
			// better way
			mid = ((toIndex - fromIndex) >> 1) + fromIndex;
			
			if (data[mid] == target) {
				return mid;
			}
			if (data[mid] > target) {
				toIndex = mid - 1;
			} else {
				fromIndex = mid + 1;
			}
		}
		
		return -1;
	}
	
	@Test
	public void testBinarySearchRecursively() {
		int[] data = {1,2,3,4,5,6};
		assertEquals(binarySearchRecursively(data, 5, 0, data.length - 1), 4);;
		
	}
	
	@Test
	public void testBinarySearchLoop() {
		int[] data = {1,2,3,4,5,6};
		assertEquals(binarySearchLoop(data, 5), 4);
	}
}
