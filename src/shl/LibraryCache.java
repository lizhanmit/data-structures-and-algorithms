package shl;

import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;

/**
 * The library has a strategy for issuing books to its members. If a requested book is not available and there is no space for new books, the least recently used (LRU) book is removed to make room for the requested one. If there is space, the book is added and marked as the most recently used. If a requested book is already in the library, it simply becomes the most recently used.
 * Your task is to determine how many times the library experiences a "miss," which occurs when a requested book is not available in the library.
 */
public class LibraryCache {


    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param numOfBookRequests
     * @param requestedBooks
     * @param cacheCapacity
     * @return
     */
    private static int numOfMisses(int numOfBookRequests, int[] requestedBooks, int cacheCapacity) {
        if (numOfBookRequests == 0 || requestedBooks.length == 0 || requestedBooks == null) {
            return 0;
        }

        if (cacheCapacity == 0) {
            return numOfBookRequests;
        }

        LinkedHashSet<Integer> cache = new LinkedHashSet<>();
        int misses = 0;

        for (int book : requestedBooks) {
            if (cache.contains(book)) {
                cache.remove(book);
                cache.add(book);
            } else {
                misses++;
                if (cache.size() == cacheCapacity) {
                    int firstBook = cache.iterator().next();
                    cache.remove(firstBook);
                }
                cache.add(book);
            }
        }

        return misses;
    }

    @Test
    public void testNumOfMisses() {
        assertEquals(0, numOfMisses(0, new int[]{1, 2, 1, 3, 1, 2}, 0));
        assertEquals(6, numOfMisses(6, new int[]{1, 2, 1, 3, 1, 2}, 0));
        assertEquals(4, numOfMisses(6, new int[]{1, 2, 1, 3, 1, 2}, 2));
    }
}
