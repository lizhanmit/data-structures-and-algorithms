package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * backtracking
 */
public class Q13 {

	private static int countOfMoving(int threshold, int rowLength, int colLength) {
		if (threshold < 0 || rowLength <= 0 || colLength <= 0) {
			return 0;
		}
		
		boolean[][] visited = new boolean[rowLength][colLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				visited[i][j] = false;
			}
		}
		
		return countOfMoving(threshold, rowLength, colLength, 0, 0, visited);
		
		
	}
	
	private static int countOfMoving(int threshold, int rowLength, int colLength, int row, int col, boolean[][] visited) {
		if (!isVisitable(threshold, rowLength, colLength, row, col, visited)) {
			return 0;
		}
		
		visited[row][col] = true;
		// 1 stands for the current cell
		return 1 + countOfMoving(threshold, rowLength, colLength, row + 1, col, visited)
				+ countOfMoving(threshold, rowLength, colLength, row - 1, col, visited)
				+ countOfMoving(threshold, rowLength, colLength, row, col + 1, visited)
				+ countOfMoving(threshold, rowLength, colLength, row, col - 1, visited);
	}
	
	private static boolean isVisitable(int threshold, int rowLength, int colLength, int row, int col, boolean[][] visited) {
		if (row >= 0 && row < rowLength && col >= 0 && col < colLength && !visited[row][col] && sumOfDigits(row) + sumOfDigits(col) <= threshold) {
			return true;
		}
		return false;
	}

	private static int sumOfDigits(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
	
	@Test
	public void testCountOfMoving() {
		assertEquals(countOfMoving(4, 4, 4), 13);
	}
}
