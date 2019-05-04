package com.zhandev.algorithm;

/**
 * 斐波那契数列全算法+优化+代码
 * https://blog.csdn.net/acecandy/article/details/83864763
 */
public class FibonacciFunc {

	/*
	 * time complexity: O(2^n)
	 * If n is big, performance is poor.
	 */
	public static long fib(int n) throws Exception {
		if (n < 1) {
			throw new Exception("n cannot be less than 1.");
		}

		if (n == 1 || n == 2) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	/*
	 * time complexity: O(n)
	 */
	public static long fibOptimized(int n) throws Exception {
		if (n < 1) {
			throw new Exception("n cannot be less than 1.");
		}
		
		if (n == 1 || n == 2) {
			return 1;
		}
		
		long a = 1;
		long b = 1;
		long c = 0;
		
		while (n - 2 > 0) {
			c = a + b;
			a = b;
			b = c;
			n--;
		}
		return c;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(fib(8));  // 21
		System.out.println(fibOptimized(8));  // 21
	}
}
