package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
 

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Dec 29, 2018 6:38:35 PM
 */
public class MostStonesRemovedwithSameRoworColumn {

	//DFS 
	//Time : O(N^2)
	//Space: O(N)
	public int removeStones(int[][] stones) {
		Set<int[]> visited = new HashSet<>();
		int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
               dfs(s1, visited, stones); 
               numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }
    
    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
    
    
    //UnionFind
    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones1(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]); //为了区分类似(2,1)和(1,2)是不连通的.
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--; //保留一个index(x or y)作为island id.
        }
    }
}
