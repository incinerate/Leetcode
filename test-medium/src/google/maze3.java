package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class maze3 {

	private static final int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static final String[] ds = new String[] { "u", "r", "d", "l" };

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(ball[0], ball[1], 0, ""));

		while (!pq.isEmpty()) {
			Point point = pq.poll();
			if (point.x == hole[0] && point.y == hole[1]) {
				return point.record;
			}
			visited[point.x][point.y] = true;

			for (int i = 0; i < dirs.length; i++) {
				int x = point.x;
				int y = point.y;
				int dist = point.distence;
				String record = point.record;

				// Explore current direction until hitting a wall or the hole
				while (isValid(maze, x+dirs[i][0], y+dirs[i][1])) {

					x += dirs[i][0];
					y += dirs[i][1];
					dist++;
					if (x == hole[0] && y == hole[1]) {
						break;
					}
				}
				if (!visited[x][y]) {
					pq.offer(new Point(x, y, dist, record + ds[i]));
				}
			}
		}
		return "impossible";
	}

	private boolean isValid(int[][] maze, int x, int y) {
		// TODO Auto-generated method stub
		return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
	}
}
