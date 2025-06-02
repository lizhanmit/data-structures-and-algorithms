package shl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A prime number is divisible only by 1 and itself. The teacher writes a positive integer on the board.
 * Write an algorithm to find all the prime numbers from 2 to the given positive number.
 */
public class PrimeNumbers {

    /**
     * Use Sieve of Eratosthenes algorithm.
     * The Sieve of Eratosthenes works by iteratively marking the multiples of each prime number starting from 2.
     * The algorithm initializes a boolean array where each index represents whether the number is prime.
     * It then marks multiples of each prime as non-prime.
     * Hence, actually, this algorithm finds all non-prime numbers first, then the remaining numbers must be primes.
     *
     * To optimize, it is only needed to process numbers up to the square root of n
     * because any non-prime number n must have a factor less than or equal to the square root of n.
     *
     * Time complexity: O(nloglogn)
     * Space complexity: O(n)
     *
     * @param n
     * @return
     */
    private static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        if (n < 2) {
            return primes;
        }

        boolean[] isPrime = new boolean[n + 1]; // up to given n, so the size of the array is n + 1 in order to include n as an index
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j +=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    @Test
    public void testFindPrimes() {
        List<Integer> primes1 = List.of(2, 3, 5, 7);
        assertEquals(primes1, findPrimes(10));

        List<Integer> primes2 = List.of(2);
        assertEquals(primes2, findPrimes(2));

        List<Integer> primes3 = List.of();
        assertEquals(primes3, findPrimes(1));
    }
}
