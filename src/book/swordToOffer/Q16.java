package book.swordToOffer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.junit.Test;

public class Q16 {
	
	/*
	 * Time: O(n)
	 * Not recommended 
	 */
	private static double pow(double base, int exponent) throws InvalidParameterException {
		if (base == 0) {
			if (exponent <= 0) {
				throw new InvalidParameterException("Exponent of 0 cannot be <= 0");
			}
			return 0;
		}
		
		if (exponent == 0) {
			return 1;
		}
		
		if (base == 1) {
			return 1;
		}
		
		double result = 1.0;
		
		// here can be optimized
		for (int i = 0; i < Math.abs(exponent); i++) {
			result *= base;
		}
		
		return exponent < 0 ? 1 / result : result;
	}
	
	/*
	 * Based on this idea: a^n = a^(n/2) * a^(n/2)
	 * Recursive manner
	 */
	private static double powOptimizedRecursively(double base, int exponent) {
		if (base == 0) {
			if (exponent <= 0) {
				throw new InvalidParameterException("Exponent of 0 cannot be <= 0");
			}
			return 0;
		}
		
		if (base == 1) {
			return 1;
		}
		
		int unsignedExponent = Math.abs(exponent);
		double result = powWithUnsignedExponent(base, unsignedExponent);
		
		return exponent < 0 ? 1 / result : result;
	}
	
	private static double powWithUnsignedExponent(double base, int unsignedExponent) {
		if (unsignedExponent == 0) {
			return 1;
		}
		
		if (unsignedExponent == 1) {
			return base;
		}
		
		// use >> 1 to replace / 2
		double result = powWithUnsignedExponent(base, unsignedExponent >> 1);
		result *= result;
		
		// if unsignedExponent is odd, return result * base
		return (unsignedExponent & 1) == 1 ? result * base : result;
	}
	
	/*
	 * Based on this idea: a^n = a^(n/2) * a^(n/2)
	 * Loop manner
	 * Time: O(log n)
	 * Better, recommended
	 */
	private static double powOptimizedLoop(double base, int exponent) {
		if (base == 0) {
			if (exponent <= 0) {
				throw new InvalidParameterException("Exponent of 0 cannot be <= 0"); 
			}
			return 0;
		}
		
		if (base == 1) {
			return 1;
		}
		
		int unsignedExponent = Math.abs(exponent);
		double result = 1.0;
		
		while (unsignedExponent != 0) {
			if ((unsignedExponent & 1) == 1) {
				result *= base;
			}
			
			base *= base;
			unsignedExponent = unsignedExponent >> 1;
		}
		
		return exponent < 0 ? 1 / result : result;
	}
	
	@Test
	public void testPow() throws InvalidParameterException {
		assertEquals(pow(2, 0), 1, 0.000000001);
		assertEquals(pow(2, 1), 2, 0.000000001);
		assertEquals(pow(2, -1), 0.5, 0.000000001);
		try {
			pow(0, -2);
			fail("Expected an InvalidParameterException to be thrown");
		} catch (InvalidParameterException e) {
			assertThat(e.getMessage(), is("Exponent of 0 cannot be <= 0"));
		}
	}
	
	@Test
	public void testPowOptimizedRecursively() {
		assertEquals(powOptimizedRecursively(2, 0), 1, 0.000000001);
		assertEquals(powOptimizedRecursively(2, 1), 2, 0.000000001);
		assertEquals(powOptimizedRecursively(2, -1), 0.5, 0.000000001);
		try {
			powOptimizedRecursively(0, -2);
			fail("Expected an InvalidParameterException to be thrown");
		} catch (InvalidParameterException e) {
			assertThat(e.getMessage(), is("Exponent of 0 cannot be <= 0"));
		}
	}
	
	@Test
	public void testPowOptimizedLoop() {
		assertEquals(powOptimizedLoop(2, 0), 1, 0.000000001);
		assertEquals(powOptimizedLoop(2, 1), 2, 0.000000001);
		assertEquals(powOptimizedLoop(2, -1), 0.5, 0.000000001);
		try {
			powOptimizedLoop(0, -2);
			fail("Expected an InvalidParameterException to be thrown");
		} catch (InvalidParameterException e) {
			assertThat(e.getMessage(), is("Exponent of 0 cannot be <= 0"));
		}
	}
}
