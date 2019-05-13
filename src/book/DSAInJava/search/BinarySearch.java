package book.DSAInJava.search;

public class BinarySearch {

	public static int binarySearchRecursively(int[] data, int target, int fromIndex, int toIndex) {
		if (data[0] > target || data[data.length - 1] < target || fromIndex > toIndex) {
			return -1;  // if can find the target, return -1 
		}
		
		int mid = (fromIndex + toIndex) / 2;
		
		if (target == data[mid]) {
			return mid;
		}
		
		if (target < data[mid]) {
			return binarySearchRecursively(data, target, fromIndex, mid - 1);
		} 
		
		return binarySearchRecursively(data, target, mid + 1, toIndex);
	}
	
	public static int binarySearchLoop(int[] data, int target) {
		if (data == null || data[0] > target || data[data.length - 1] < target) {
			return -1;
		}
		
		int fromIndex = 0;
		int toIndex = data.length - 1;
		int mid = 0;
		
		while (fromIndex <= toIndex) {
			mid = (fromIndex + toIndex) / 2;
			if (data[mid] == target) {
				return mid;
			}
			if (data[mid] > target) {
				toIndex = mid - 1;
			} else {
				fromIndex = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6};
		System.out.println(binarySearchRecursively(data, 5, 0, data.length - 1));
		System.out.println(binarySearchLoop(data, 5));
	}
}
