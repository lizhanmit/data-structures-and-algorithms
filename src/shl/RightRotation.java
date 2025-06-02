package shl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Charlie has a magic mirror that shows the right-rotated versions of a given word. To generate different right rotations of a word, the word is written in a circle in a clockwise order and read it starting from any given character in a clockwise order until all the characters are covered. For example, in the word "sample", if we start with 'p', we get the right rotated word as "plesam"
 * Write an algorithm to output 1 if the word1 is a right rotation of word2 otherwise output -1.
 */
public class RightRotation {

    private static int isRightRotation(String w1, String w2) {
        if (w1 == null || w2 == null || w1.length() != w2.length()) {
            return -1;
        }

        if (w1.equals("") || w1.equals(w2)) {
            return 1;
        }

        String doubleW2 = w2 + w2;
        if (doubleW2.contains(w1)) {
            return 1;
        }

        return -1;
    }

    @Test
    public void testIsRightRotation() {
        assertEquals(1, isRightRotation("plesam", "sample"));
        assertEquals(1, isRightRotation("abc", "bca"));
        assertEquals(-1, isRightRotation("abc", "bac"));
        assertEquals(1, isRightRotation("", ""));
        assertEquals(1, isRightRotation("a", "a"));
        assertEquals(-1, isRightRotation(null, "bac"));
    }
}
