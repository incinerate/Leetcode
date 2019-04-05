package google;

import java.util.LinkedList;
/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

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

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.

 

Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 29, 2018 8:18:47 PM
 */
public class maze {
	
	/*
	 * dfs faster
	 */

	private static final int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	//bfs
	public boolean hasPath_bfs(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		if (start[0] == destination[0] && start[1] == destination[1])
			return true;
		int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		boolean[][] visited = new boolean[m][n];
		LinkedList<Point> l = new LinkedList<>();
		visited[start[0]][start[1]] = true;
		l.offer(new Point(start[0], start[1]));
		while (!l.isEmpty()) {
			Point p = l.poll();
			visited[p.x][p.y] = true;
			for (int[] direction : dir) {
				int newX = p.x, newY = p.y;
				while (isValid(maze, newX + direction[0], newY + direction[1])) {
					newX += direction[0];
					newY += direction[1];
				}
				if (newX == destination[0] && newY == destination[1])
					return true;
				if (!visited[newX][newY])
					l.offer(new Point(newX, newY));
			}
		}
		return false;

	}

	// dfs
	public boolean hasPath_dfs(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length]; // mark visited starting points
		return dfs(maze, start, destination, visited);
	}

	private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
		int m = maze.length, n = maze[0].length;
		if (visited[start[0]][start[1]])
			return false;
		if (start[0] == destination[0] && start[1] == destination[1])
			return true;
		visited[start[0]][start[1]] = true;
		for (int[] dir : dirs) {
			int newX = start[0];
			int newY = start[1];
			while (isValid(maze, newX + dir[0], newY + dir[1])) {
				newX += dir[0];
				newY += dir[1];
			}

			if (dfs(maze, new int[] { newX, newY }, destination, visited))
				return true;
		}
		return false;
	}

	private boolean isValid(int[][] maze, int x, int y) {
		// TODO Auto-generated method stub
		return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
	}
}
