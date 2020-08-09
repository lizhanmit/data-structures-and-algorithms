package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q5a {

	/*
	 * Replace spaces in string to "%20".
	 * O(n) time
	 * O(n) space
	 */
	public static String replaceSpace(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		
		int numOfSpace = 0;
		// count number of space in the string
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				numOfSpace++;
			}
		}
		
		StringBuilder newStr = new StringBuilder("");
		newStr.setLength(s.length() + numOfSpace * 2);
		
		int frontIndex = s.length() - 1;
		int rearIndex = newStr.length() - 1;
		
		while (frontIndex >= 0) {
			if (Character.isWhitespace(s.charAt(frontIndex))) {
				newStr.setCharAt(rearIndex--, '0');
				newStr.setCharAt(rearIndex--, '2');
				newStr.setCharAt(rearIndex--, '%');
			} else {
				newStr.setCharAt(rearIndex--, s.charAt(frontIndex));
			}
			frontIndex--;
		}
		
		return newStr.toString();
	}
	
	@Test
	public void testReplaceSpace() {
		assertEquals(replaceSpace("We Are Happy."), "We%20Are%20Happy.");
		assertEquals(replaceSpace(" We Are Happy. "), "%20We%20Are%20Happy.%20");
		assertEquals(replaceSpace("  "), "%20%20");
	}
}
