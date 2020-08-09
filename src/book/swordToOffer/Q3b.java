package book.swordToOffer;

public class Q3b {

	public static int findDuplicate(int[] number) {
		int length = number.length;
		
		if (number == null || length == 0) {
			return -1;
		}
		
		for (int i = 0; i < length; i++) {
			if (number[i] <= 0 || number[i] >= length) {
				return -1;
			}
		}
		
		int[] temp = new int[length];
		
		for (int i = 0; i < length; i++) {
			if (number[i] == temp[number[i]]) {
				return number[i];
			}
			temp[number[i]] = number[i];
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] numbers = {2, 1, 5, 4, 3, 2, 6, 3};
        System.out.println(findDuplicate(numbers));
	}
}
