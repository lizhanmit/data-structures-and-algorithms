package book.DSAInJava.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6};
		System.out.println(binarySearch(data, 5, 0, data.length - 1));
	}
	
	private static boolean binarySearch(int[] data, int target, int low, int high) {
		if (low > high) {
			return false;
		}
		
		int mid = (low + high) / 2;
		
		if (target == data[mid]) {
			return true;
		}
		
		if (target < data[mid]) {
			return binarySearch(data, target, low, mid - 1);
		} 
		
		return binarySearch(data, target, mid + 1, high);
	}
}
