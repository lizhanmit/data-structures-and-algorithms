package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q4 {
	public static boolean hasTargetNum(int[][] array, int target) {
		if (array == null || array.length == 0) {
			return false;
		}
		
		int rowLength = array.length;
		int columnLength = array[0].length;
		
		int i = 0, j = columnLength-1;
		
		while (i < rowLength && j >= 0) {
			if (array[i][j] == target) {
				return true;
			}
			if (array[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
	
	@Test
	public void testHasTargetNum() {
		int array[][] = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
		assertEquals(hasTargetNum(array, 5), false);
		assertEquals(hasTargetNum(array, 7), true);
	}
}
