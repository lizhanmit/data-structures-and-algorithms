package book.DSAInJava.sorting;

import java.util.Arrays;

import org.junit.Test;

/**
 * Sort ages of employees in a company. 
 * Tens of thousands of employees.
 * Time: O(n)
 * 
 * Analysis: 
 * There is a range of age: 18~65
 * Use counting sort.
 */
public class AgeSorting {

	public static void countSortAges(int[] ages) throws Exception {
		if (ages == null || ages.length == 0) {
			return;
		}
		
		int[] timesOfAge = new int[65 - 18 + 1];
		Arrays.fill(timesOfAge, 0);
		
		for(int i = 0; i < ages.length; i++) {
			if (ages[i] < 18 || ages[i] > 65) {
				throw new Exception("Age out of range.");
			}
			timesOfAge[ages[i] - 18]++;
		}
		
		int index = 0;
		for (int i = 0; i < timesOfAge.length; i++) {
			for (int j = 0; j < timesOfAge[i]; j++) {
				ages[index] = i + 18;
				index++;
			}
		}
	}
	
	@Test
	public void testCountSortAges() throws Exception {
		int[] ages = {20,18,30,25,40,35,50,20,18};
		countSortAges(ages);
		System.out.println(Arrays.toString(ages));
	}
}
