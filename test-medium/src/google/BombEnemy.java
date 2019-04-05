package google;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Feb 5, 2019 12:31:28 AM
 */
public class BombEnemy {

	/*
	 * ˼·��StraightForward���Ȱ��п���������ÿһ�еĿ�λ�Ϸ�bomb��ɱ����enemy������Wall�Ĵ��ڣ�����bomb��W�����ҽ��
	 * ���ܲ�ͬ�����������������Σ�һ�δ������ң�һ�δ������󣬼�¼�������ά���顣Ȼ���п���ͬ�����õ���ά�������������������
	 */
	// Time: O(mn)
	// Space: O(mn)
	public int maxKilledEnemies(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		int[][] count = new int[m][n];
		int res = 0;
		//
		for (int i = 0; i < m; i++) {
			int tmp = 0;
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'E')
					tmp++;
				if (grid[i][j] == 'W')
					tmp = 0;
				if (grid[i][j] == '0') {
					count[i][j] += tmp;
					res = Math.max(count[i][j], res);
				}
			}
			tmp = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 'E')
					tmp++;
				if (grid[i][j] == 'W')
					tmp = 0;
				if (grid[i][j] == '0') {
					count[i][j] += tmp;
					res = Math.max(count[i][j], res);
				}
			}
		}
		for (int j = 0; j < n; j++) {
			int tmp = 0;
			for (int i = 0; i < m; i++) {
				if (grid[i][j] == 'E')
					tmp++;
				if (grid[i][j] == 'W')
					tmp = 0;
				if (grid[i][j] == '0') {
					count[i][j] += tmp;
					res = Math.max(count[i][j], res);
				}
			}
			tmp = 0;
			for (int i = m - 1; i >= 0; i--) {
				if (grid[i][j] == 'E')
					tmp++;
				if (grid[i][j] == 'W')
					tmp = 0;
				if (grid[i][j] == '0') {
					count[i][j] += tmp;
					res = Math.max(count[i][j], res);
				}
			}
		}
		return res;
	}
}
