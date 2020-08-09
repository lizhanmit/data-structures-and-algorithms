package leetcode.explore.array;

/**
 *   矩阵顺时针旋转90度 = 先按主对角线翻转，再按垂直对称线翻转
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/
 */
public class MatrixRotate {
	public void rotate(int[][] matrix) {
		if (matrix == null) return;
		
		int len = matrix.length;
		
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			
			// ">> 1" is used to replace "/ 2"
			for (int j = 0; j < len >> 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len - 1 - j];
				matrix[i][len - 1 - j] = temp;
			}
		}
    }
}
