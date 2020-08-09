package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q15 {

	/*
	 * Right shift the input number.
	 */
	private static int numberOfOneInBinaryRightShiftMethod(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				count++;
			}
			
			// here use >>> rather than >>
			// because if num is negative, >> will pad 1 at the most left side,
			// then dead loop
			num = num >>> 1;
		}
		return count;
	}
	
	/*
	 * Left shift the flag number 1.
	 */
	private static int numberOfOneInBinaryLeftMethod(int num) {
		// if num is 0, return 0 directly
		// because cannot calculate log 0
		if (num == 0) {
			return 0;
		}
		
		int count = 0;
		int flag = 1;
		
		// if num is positive, calculate the number of digit of its binary (excluding front 0) using log
		//int shiftTimes = 0;
		if (num > 0) {
			int shiftTimes = (int) (Math.log(num) / Math.log(2)) + 1;
			while (shiftTimes > 0 && flag != 0) {
				if ((num & flag) != 0) {
					count++;
				}
				flag = flag << 1;
				shiftTimes--;
			}
			return count;
		}
		
		// if num is negative
		while (flag != 0) {
			if ((num & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	/*
	 * Minus the num by 1, then & the origin num, then most right 1 of the origin number will become 0. 
	 * Count how many this operation can be done, then you can get number of one in binary.
	 */
	private static int numberOfOneInBinary(int num) {
		int count = 0;
		
		while (num != 0) {
			num = (num - 1) & num;
			count++;
		}
		
		return count++;
	}
	
	@Test
	public void testNumberOfOneInBinaryRightShiftMethod() {
		assertEquals(numberOfOneInBinaryRightShiftMethod(0), 0);
		assertEquals(numberOfOneInBinaryRightShiftMethod(9), 2);
		assertEquals(numberOfOneInBinaryRightShiftMethod(-9), 31);
	}
	
	@Test
	public void testNumberOfOneInBinaryLeftMethod() {
		assertEquals(numberOfOneInBinaryLeftMethod(0), 0);
		assertEquals(numberOfOneInBinaryLeftMethod(9), 2);
		assertEquals(numberOfOneInBinaryLeftMethod(-9), 31);
	}
	
	@Test
	public void testNumberOfOneInBinary() {
		assertEquals(numberOfOneInBinary(0), 0);
		assertEquals(numberOfOneInBinary(9), 2);
		assertEquals(numberOfOneInBinary(-9), 31);
	}
	
	public static void main(String[] args) {
		System.out.println(numberOfOneInBinaryRightShiftMethod(1));
	}
}
