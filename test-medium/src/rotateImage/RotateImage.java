package rotateImage;

/**
 * 
 * @title Rotate Image
 * @description You are given an n x n 2D matrix representing an image.
 * 
 *              Rotate the image by 90 degrees (clockwise).
 * 
 *              Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * 
 *              rotate the input matrix in-place such that it becomes: [
 *              [7,4,1], [8,5,2], [9,6,3] ]
 * @author Cun Shi
 * @date: 2018年1月23日 下午9:34:02
 */
public class RotateImage {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int temp = 0;
		for (int i = 0; i < n / 2; i++) {
			if (n % 2 == 0) {
				for (int j = 0; j < n / 2; j++) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[n - j - 1][i];
					matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
					matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
					matrix[j][n - i - 1] = temp;
				}
			} else {
				for (int j = 0; j <= n / 2; j++) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[n - j - 1][i];
					matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
					matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
					matrix[j][n - i - 1] = temp;
				}
			}
		}
	}
}
