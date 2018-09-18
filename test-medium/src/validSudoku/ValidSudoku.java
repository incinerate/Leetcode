package validSudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: 2017年11月15日 下午6:14:52
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return false;
		List l1 = new ArrayList<Character>();
		List l2 = new ArrayList<Character>();
		List l3 = new ArrayList<Character>();
		for (int i = 0; i < board.length; i++) {
			l1.clear();
			l2.clear();
			for (int j = 0; j < board[j].length; i++) {
				if (board[i][j] != '.') {
					if (!l1.contains(board[i][j]))
						l1.add(board[i][j]);
					else
						return false;
				}
				if (board[j][i] != '.') {
					if (!l2.contains(board[j][i]))
						l2.add(board[j][i]);
					else
						return false;
				}
				int cubeRow = 3 * (i / 3) + j / 3;
				int cubeCol = 3 * (i % 3) + j % 3;
				if (board[cubeRow][cubeCol] != '.'){
					if(!l3.contains(board[cubeRow][cubeCol]))
						l3.add(board[cubeRow][cubeCol]);
					else 
						return false;
				}
			}
		}
		return true;
	}
}
