package google;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {

	// dfs
	public char[][] updateBoard(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		int x = click[0], y = click[1];

		if (board[x][y] == 'M') { // Mine
			board[x][y] = 'X';
		} else { // Empty
					// Get number of mines first.
			int count = 0;
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == 0 && j == 0)
						continue;
					int r = x + i, c = y + j;
					if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
						continue;
					if (board[r][c] == 'M' || board[r][c] == 'X')
						count++;
				}
			}

			if (count > 0) { // If it is not a 'B', stop further DFS.
				board[x][y] = (char) (count + '0');
			} else { // Continue DFS to adjacent cells.
				board[x][y] = 'B';
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0)
							continue;
						int r = x + i, c = y + j;
						if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
							continue;
						if (board[r][c] == 'E')
							updateBoard(board, new int[] { r, c });
					}
				}
			}
		}

		return board;
	}

	public char[][] updateBoard_dfs(char[][] board, int[] click) {
		int x = click[0];
		int y = click[1];

		if (board[x][y] == 'M')
			board[x][y] = 'X';
		else
			dfs(board, x, y);

		return board;
	}

	public void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[i].length - 1 || board[i][j] != 'E')
			return;
		board[i][j] = adjacentMines(board, i, j);
		if (board[i][j] != 'B')
			return;
		dfs(board, i + 1, j);
		dfs(board, i - 1, j);
		dfs(board, i, j + 1);
		dfs(board, i, j - 1);

		dfs(board, i + 1, j + 1);
		dfs(board, i + 1, j - 1);
		dfs(board, i - 1, j + 1);
		dfs(board, i - 1, j - 1);

	}

	// count how many mines in the 3x3 grid arround coordinate
	public char adjacentMines(char[][] board, int i, int j) {
		int count = 0;

		for (int r = i - 1; r < i + 2; r++) {
			for (int c = j - 1; c < j + 2; c++) {
				if (!(r < 0 || c < 0 || r > board.length - 1 || c > board[r].length - 1) && board[r][c] == 'M')
					count++;

			}
		}

		return count == 0 ? 'B' : (char) ('0' + count);
	}

	public char[][] updateBoard_bfs(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(click);

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int row = cell[0], col = cell[1];

			if (board[row][col] == 'M') { // Mine
				board[row][col] = 'X';
			} else { // Empty
						// Get number of mines first.
				int count = 0;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0)
							continue;
						int r = row + i, c = col + j;
						if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
							continue;
						if (board[r][c] == 'M' || board[r][c] == 'X')
							count++;
					}
				}

				if (count > 0) { // If it is not a 'B', stop further BFS.
					board[row][col] = (char) (count + '0');
				} else { // Continue BFS to adjacent cells.
					board[row][col] = 'B';
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							if (i == 0 && j == 0)
								continue;
							int r = row + i, c = col + j;
							if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
								continue;
							if (board[r][c] == 'E') {
								queue.add(new int[] { r, c });
								board[r][c] = 'B'; // Avoid to be added again.
							}
						}
					}
				}
			}
		}

		
		return board;
	}
}
