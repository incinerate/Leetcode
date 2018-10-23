package google;
/**
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 12, 2018 11:59:14 PM
 */
public class GameOfLife {

	/**
	 * 创建一个2D数组去存储各个点周围1的个数，再最后遍历，统一update
	 * @param board
	 */
	public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				flag[i][j] = helper(board, i-1, j-1)+helper(board, i-1, j)+helper(board, i-1, j+1)+helper(board, i, j-1)
				+helper(board, i, j+1)+helper(board, i+1, j-1)+helper(board, i+1, j)+helper(board, i+1, j+1);
			}
		}
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == 1 && flag[i][j]<2) {
					board[i][j] = 0;
				}else if(board[i][j] == 1 && flag[i][j]>3){
					board[i][j] = 0;
				}else if (board[i][j] == 0 && flag[i][j] == 3) {
					board[i][j] = 1;
				}
			}
		}
    }

	private int helper(int[][] board, int i, int j) {
		// TODO Auto-generated method stub
		if(i<0 || j<0 || i>board.length-1 || j> board[0].length-1)
			return 0;
		return board[i][j];
	}
}
