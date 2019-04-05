package google;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

 

Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12

Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1

Explanation: There is no way for the ball to stop at the destination.

 

Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Nov 29, 2018 8:20:25 PM
 */
public class maze2 {

	private static final int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	// bfs faster, 不需要visited数组What I mean is, this check not a visited check,
	// if the same node be visited twice but the second time it has a shorter
	// distance,
	// then we still allow it be visited again. Hope this is clear.
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		int[][] length = new int[m][n];
		for (int[] l : length) {
			Arrays.fill(l, m * n);
		}
		LinkedList<Point> l = new LinkedList<>();
		l.offer(new Point(start[0], start[1], 0));
		while (!l.isEmpty()) {
			Point p = l.poll();
			if (length[p.x][p.y] <= p.distence)
				continue; // if we have already found a route shorter
			length[p.x][p.y] = p.distence;
			for (int[] direction : dirs) {
				int newX = p.x, newY = p.y, newDistence = p.distence;
				while (isValid(maze, newX + direction[0], newY + direction[1])) {
					newX += direction[0];
					newY += direction[1];
					newDistence++;
				}
				l.offer(new Point(newX, newY, newDistence));
			}
		}
		return length[destination[0]][destination[1]] == m * n ? -1 : length[destination[0]][destination[1]];
	}

	public int shortestDistance_dfs(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		int[][] length = new int[m][n];
		for (int[] d : length) {
			Arrays.fill(d, m * n);
		}
		length[start[0]][start[1]] = 0;
		dfs(maze, start, length);
		return length[destination[0]][destination[1]] == m * n ? -1 : length[destination[0]][destination[1]];
	}

	public void dfs(int[][] maze, int[] start, int[][] length) {
		int m = maze.length, n = maze[0].length;
		for (int[] dir : dirs) {
			int row = start[0];
			int col = start[1];
			int dist = length[row][col];
			while (isValid(maze, row + dir[0], col + dir[1])) {
				row += dir[0];
				col += dir[1];
				dist++;
			}
			if (dist < length[row][col]) {
				length[row][col] = dist;
				dfs(maze, new int[] { row, col }, length);
			}
		}
	}

	private boolean isValid(int[][] maze, int x, int y) {
		// TODO Auto-generated method stub
		return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
	}
}
