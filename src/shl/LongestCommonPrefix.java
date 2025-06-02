package shl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * There are N people living in a state. In this state, people concatenate their town name before their first name.
 * Write an algorithm to find the name of the town of the given N people where the name of the town is the common substring and has the maximum length.
 */
public class LongestCommonPrefix {

    /**
     * Time complexity: O(the average length of strings * the number of strings)
     * Space complexity: O(1)
     *
     * @param names
     * @return
     */
    private static String findTownName(String[] names) {
        if (names == null || names.length == 0) {
            return "";
        }

        String first = names[0];
        int len = first.length();

        for (int i = 1; i < names.length; i++) {
            String s = names[i];
            int j = 0;

            while (j < len && j < s.length()) {
                if (s.charAt(j) != first.charAt(j)) {
                    break;
                }
                j++;
            }

            len = Math.min(len, j);
            if (len == 0) {
                return "";
            }
        }

        return first.substring(0, len);
    }


    @Test
    public void testFindTownName() {
        String[] names1 = {"CHICAGOjoe", "CHICAGOjane", "CHICAGOjohn"};
        assertEquals("CHICAGOj", findTownName(names1));

        String[] names2 = {"ABC", "ABD"};
        assertEquals("AB", findTownName(names2));

        String[] names3 = {"hello", "world"};
        assertEquals("", findTownName(names3));

        String[] names4 = null;
        assertEquals("", findTownName(names4));

        String[] names5 = {};
        assertEquals("", findTownName(names5));

        String[] names6 = {"", ""};
        assertEquals("", findTownName(names6));
    }
}
