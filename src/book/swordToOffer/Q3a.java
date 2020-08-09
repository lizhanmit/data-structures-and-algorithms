package book.swordToOffer;

public class Q3a {
	
	private static int duplicateNum;
	
	/**
	 * time complexity: O(n)
	 * space complexity: O(1)
	 * 
	 * @param number
	 * @param length  length of the number array
	 * @param duplicateNum  used to store the first duplicate number
	 * @return
	 */
	public static boolean isDuplicate(int[] number, int length) {
		if (number == null || length < 0) {
			return false;
		}
		
		for (int i = 0; i < length; i++) {
			if (number[i] < 0 || number[i] > length - 1) {
				return false;
			}
		}
		
		for (int i = 0; i < length; i++) {
			while (i != number[i]) {
				if (number[i] == number[number[i]]) {
					duplicateNum = number[i];
					return true;
				}
				swap(number, i, number[i]);
			}
		}
		return false;
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
        int[] numbers = {2, 1, 5, 4, 3, 2, 6, 7};
        System.out.println(isDuplicate(numbers, 8));
        System.out.println(duplicateNum);
    }
}
