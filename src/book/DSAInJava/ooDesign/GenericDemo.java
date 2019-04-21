package book.DSAInJava.ooDesign;

public class GenericDemo {
	/**
	 * Generic Methods 
	 * reverse a generic array
	 */
	public static <T> void reverse(T[] data) {
		int low = 0, high = data.length - 1;
		while (low > high) {
			T temp = data[low];
			data[low++] = data[high];
			data[high--] = temp;
		}
	}
}
