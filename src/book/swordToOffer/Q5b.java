package book.swordToOffer;

import java.util.Arrays;

import org.junit.Test;

public class Q5b {

	/*
	 * a and b are sorted arrays.
	 * a has enough space at the end to include b.
	 * Insert b to a and finally a is sorted.
	 */
	public static void mergeArrays(Integer[] a, Integer[] b) {
		if (a == null || b == null || b[0] == null) {
			return;
		}
		
		// if a has no element, copy b to a directly
		if (a[0] == null) {
			for (int i = 0; i < b.length; i++) {
				a[i] = b[i];
			}
			return;
		}
		
		int aIndex = 0;
		while (aIndex < a.length) {
			if (a[aIndex] == null) {
				aIndex--;
				break;
			}
			aIndex++;
		}
		
		int bIndex = b.length - 1;
		
		int rearIndex = aIndex + b.length;
		
		while (rearIndex >= 0) {
			if (bIndex < 0) {
				break;
			} else if (aIndex < 0 || b[bIndex] > a[aIndex]) {
				a[rearIndex] = b[bIndex--];
			} else if (b[bIndex] < a[aIndex]){
				a[rearIndex] = a[aIndex--];
			} else {
				a[rearIndex--] = a[aIndex--];
				// do not rearIndex-- here
				a[rearIndex] = b[bIndex--];
			}
			
			rearIndex--;
		}
	}
	
	@Test
	public void testMergeArrays() {
		Integer[] a = new Integer[15];
        Integer[] b = {1, 3, 5, 7, 9};
        for (int i = 0; i < 5; i++) {
            a[i] = 2 * i + 2;
        }
        
        mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
	}
}
