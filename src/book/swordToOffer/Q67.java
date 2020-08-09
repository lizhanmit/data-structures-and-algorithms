package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Convert a string to int.
 */
public class Q67 {

	private static int parseStringToInt(String s) {
		if (s == null || s.length() == 0 || s.equals("0")) {
			return 0;
		}
		
		int symbol = 1;
		
		if (s.charAt(0) == '-') {
			symbol = -1;
		}
		
		long result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				continue;
			}
			
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return 0;
			}
			
			result = result * 10 + s.charAt(i) - '0';
		}
		
		if (result > Integer.MAX_VALUE) {
			return 0;
		}
		
		return (int)result * symbol;
		
	}
	
	@Test
	public void testParseStringToInt() {
		assertEquals(parseStringToInt(""), 0);
		assertEquals(parseStringToInt("0"), 0);
		assertEquals(parseStringToInt("abc"), 0);
		assertEquals(parseStringToInt("000123"), 123);
		assertEquals(parseStringToInt("123"), 123);
		assertEquals(parseStringToInt("+123"), 123);
		assertEquals(parseStringToInt("-123"), -123);
	}
}
