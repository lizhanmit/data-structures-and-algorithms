package book.programmercodinginterviewguideline.chapter5string;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckAnagram {

    /**
     * Time complexity: O(the length of str)
     * Space complexity: O(the number of the type of char)
     *
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[] map = new int[256];

        for (int i = 0; i < charArr1.length; i++) {
            map[charArr1[i]]++;
        }

        for (int i = 0; i < charArr2.length; i++) {
            map[charArr2[i]]--;
            if (map[charArr2[i]] < 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testIsAnagram() {
        assertFalse(isAnagram("123", null));
        assertTrue(isAnagram("123", "231"));
        assertFalse(isAnagram("123", "2331"));
        assertTrue(isAnagram("122", "212"));
        assertFalse(isAnagram("abc", "ccc"));
        assertTrue(isAnagram("abc", "cba"));
        assertFalse(isAnagram("1a2b", "1a3c"));
        assertTrue(isAnagram("1a2b", "ba21"));
    }
}
