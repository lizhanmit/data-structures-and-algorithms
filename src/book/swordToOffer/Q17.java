package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Big number problem.
 * Typically, use a string or an array to store the big number.
 */
public class Q17 {

	private static void printFromOneToMaxOfNDigit(int n) {
		if (n <= 0) {
			return;
		}
		
		StringBuilder number = new StringBuilder();
		for (int i = 0; i < n; i++) {
			number.append("0");
		}
		
		while (needIncrease(number)) {
			printWithPrecedingZero(number);
		}
	}
	
	private static boolean needIncrease(StringBuilder number) {
		int carryOver = 0;
		int sumForSomeDigit = 0;
		
		// loop of carry over
		for (int i = number.length() - 1; i >= 0; i--) {
			sumForSomeDigit = number.charAt(i) - '0' + carryOver;
			
			// if it is at single digit
			if (i == number.length() - 1) {
				sumForSomeDigit++;
			}
			
			// if == 10, need to carry over
			if (sumForSomeDigit == 10) {
				if (i == 0) {
					return false;
				}
				
				number.setCharAt(i, '0');
				carryOver = 1;
			} else {
				number.setCharAt(i, (char) (sumForSomeDigit + '0'));
				// no more carry over, break
				break;
			}
		}
		return true;
	}

	private static void printWithPrecedingZero(StringBuilder number) {
		int startIndexToPrint = 0;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) != '0') {
				startIndexToPrint = i;
				break;
			}
		}
		
		if (startIndexToPrint < number.length()) {
			System.out.print(number.substring(startIndexToPrint) + " ");
		}
	}

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Test
	public void testPrintFromOneToMaxOfNDigit() {
		printFromOneToMaxOfNDigit(1);
		assertEquals("1 2 3 4 5 6 7 8 9 ", systemOutRule.getLog());
	}
}
