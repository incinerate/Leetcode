package google;

/**
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks. A brick will
 * not drop if and only if it is directly connected to the top of the grid, or
 * at least one of its (4-way) adjacent bricks will not drop.
 * 
 * We will do some erasures sequentially. Each time we want to do the erasure at
 * the location (i, j), the brick (if it exists) on that location will
 * disappear, and then some other bricks may drop because of that erasure.
 * 
 * Return an array representing the number of bricks that will drop after each
 * erasure in sequence.
 * 
 * Example 1: Input: grid = [[1,0,0,0],[1,1,1,0]] hits = [[1,0]] Output: [2]
 * Explanation: If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2)
 * will drop. So we should return 2. Example 2: Input: grid =
 * [[1,0,0,0],[1,1,0,0]] hits = [[1,1],[1,0]] Output: [0,0] Explanation: When we
 * erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to
 * the last move. So each erasure will cause no bricks dropping. Note that the
 * erased brick (1, 0) will not be counted as a dropped brick.
 * 
 * 
 * Note:
 * 
 * The number of rows and columns in the grid will be in the range [1, 200]. The
 * number of erasures will not exceed the area of the grid. It is guaranteed
 * that each erasure will be different from any other erasure, and located
 * inside the grid. An erasure may refer to a location with no brick - if it
 * does, no bricks drop.
 * 
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Nov 5, 2018 2:37:38 PM
 */
public class BricksFallingWhenHit {
	
	/*
	 * ˼·������DFS�н��ѵ�һ���⡣��������Ҫ����brick drop��������1.grid��ɾ���Ľڵ�Ϊ1��2.ɾ��λ�õĽڵ�����top(grid[0][])������
	 * 3.ɾ���ڵ����Χ��brick �ڵ���벻��ͨ������brick����top������ֻ��ͬʱ��������3��������brick�Ż�drop��
	 * �����Ȱ�����Ҫbrick�Ľڵ���Ϊ0����һ�е�����brick���ΪTOP(2)��Ȼ����DFS��˳�������ҵ�������TOP��ͨ��grid��
	 * ��һ�����ǻָ�hits�ڵ㵽1��isConnected(x, y, grid)���������жϵڶ���������dfs�������صľ�����Ϊhits��ԭ����TOP
	 * �Ͽ����ӵ�grid�ĸ�������һ����ΪҪ��ȥhit����
	 */

	private static final int TOP = 2;
	private static final int BRICK = 1;
	private static final int EMPTY = 0;
	private static final int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int[] hitBricks(int[][] grid, int[][] hits) {
		int[] res = new int[hits.length];
		// Think backwards: remove all of the hits and then add them back;
		for (int[] hit : hits) {
			grid[hit[0]][hit[1]]--;
		}

		// Flood all the grids connecting to top with 2;
		for (int i = 0; i < grid[0].length; i++) {
			dfs(0, i, grid);
		}

		// Add back the hited Bricks
		for (int i = hits.length - 1; i >= 0; i--) {
			int x = hits[i][0], y = hits[i][1];
			grid[x][y]++;
			if (grid[x][y] == BRICK && isConnected(x, y, grid)) {
				res[i] = dfs(x, y, grid) - 1;
			}
		}

		return res;
	}

	private int dfs(int i, int j, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != BRICK) {
			return 0;
		}
		grid[i][j] = 2;
		return dfs(i + 1, j, grid) + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i, j - 1, grid) + 1;
	}

	private boolean isConnected(int i, int j, int[][] grid) {
		if (i == 0) {
			return true;
		}
		for (int[] d : DIRS) {
			int x = i + d[0], y = j + d[1];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == TOP) {
				return true;
			}
		}
		return false;
	}
}
