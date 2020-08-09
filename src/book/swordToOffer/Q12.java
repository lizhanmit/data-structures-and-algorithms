package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Find a path in a matrix.
 * backtracking 
 */
public class Q12 {
	private boolean hasPath(char[][] matrix, String target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target == null || target.equals("")) {
			return false;
		}
		
		boolean[][] visited = new boolean[matrix.length][];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = new boolean[matrix[i].length];
			Arrays.fill(visited[i], false);
		}
		
		char[] targetArr = target.toCharArray();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (hasPath(matrix, matrix.length, matrix[0].length, i, j, 0, targetArr, visited)) {
					return true;
				}
			}
		}
		
		return false;
	}

	private boolean hasPath(char[][] matrix, int rowLength, int colLength, int row, int col, int pathLength, char[] targetArr,
			boolean[][] visited) {

		// if the target array has been searched over
		if (pathLength == targetArr.length) {
			return true;
		}
		
		boolean hasPath = false;
		
		// found one
		if (row >= 0 && row < rowLength && col >= 0 && col < colLength && targetArr[pathLength] == matrix[row][col] && !visited[row][col]) {
			pathLength++;
			visited[row][col] = true;
			
			// check the next
			hasPath = hasPath(matrix, rowLength, colLength, row + 1, col, pathLength, targetArr, visited)
					|| hasPath(matrix, rowLength, colLength, row - 1, col, pathLength, targetArr, visited)
					|| hasPath(matrix, rowLength, colLength, row, col + 1, pathLength, targetArr, visited)
					|| hasPath(matrix, rowLength, colLength, row, col - 1, pathLength, targetArr, visited);
					
			if (!hasPath) {
				pathLength--;
				visited[row][col] = false;
			}
		}
		
		return hasPath;
	}
	
	@Test
	public void testHasPath() {
		char[][] matrix = {{'a', 'b', 't', 'g' }, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
		assertEquals(hasPath(matrix, "bfce"), true);
		assertEquals(hasPath(matrix, "abfb"), false);
	}
}
