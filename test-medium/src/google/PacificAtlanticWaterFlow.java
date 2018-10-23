package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "P ocean" touches the left and top edges of the matrix and the "A ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the P and A ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  P ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * A

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 14, 2018 8:44:15 PM
 */
public class PacificAtlanticWaterFlow {
	
		/**
		 * 思路：类似于找最大联通岛题，首先建立两个数据，描述该点是否可以flow到Pacific和Atlantic。
		 * 然后P从左上角开始，A从右下角开始探索，直到探索完全部点
		 * 
		 */

		static int[] dx = {-1,0,0,1};
		static int[] dy = {0,1,-1,0};
		public List<int[]> pacificAtlantic(int[][] matrix) {
		    List<int[]> res = new ArrayList<>();
		    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
		    boolean[][] P = new boolean[matrix.length][matrix[0].length];
		    boolean[][] A = new boolean[matrix.length][matrix[0].length];
		    for (int i = 0; i < matrix.length; i++){
		        P[i][0] = true;
		        A[i][matrix[0].length-1] = true;
		    }
		    for (int j = 0; j < matrix[0].length; j++){
		        P[0][j] = true;
		        A[matrix.length-1][j] = true;
		    }
		    for (int i = 0; i < matrix.length; i++){
		        explore(P, matrix, i, 0);
		        explore(A, matrix, i, matrix[0].length-1);
		    }
		    for (int j = 0; j < matrix[0].length; j++){
		        explore(P, matrix, 0, j);
		        explore(A, matrix, matrix.length-1, j);
		    }
		    for (int i = 0; i < matrix.length; i++){
		        for (int j = 0; j < matrix[0].length; j++){
		            if (P[i][j] && A[i][j] == true)
		                res.add(new int[]{i,j});
		        }
		    }
		    return res;
		    
		}
		private void explore(boolean[][] grid, int[][] matrix, int i, int j){
		    grid[i][j] = true;
		    for (int d = 0; d < dx.length; d++){
		        if (i+dy[d] < grid.length && i+dy[d] >= 0 && 
		            j + dx[d] < grid[0].length && j + dx[d] >= 0 && 
		            grid[i+dy[d]][j+dx[d]] == false && matrix[i+dy[d]][j+dx[d]] >= matrix[i][j])
		                explore(grid, matrix, i+dy[d], j+dx[d]);
		    }
		}
}
