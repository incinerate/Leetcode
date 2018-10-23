package google;
/**
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 16, 2018 6:05:58 PM
 */
public class LongestIncreasingPathinaMatrix {

	public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m=matrix.length, n=matrix[0].length, res=0;
        
        //用于存储历史每个点的最大长度，防止了反复计算，相当于一个cache
        int[][] memo= new int[m][n];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                res=Math.max(res, dfs(matrix, i, j, memo, -1));
        return res;
    }
    public int dfs(int[][] matrix, int i, int j, int[][] memo, int cur){
        int m=matrix.length, n=matrix[0].length, res=0;
        if (i<0 || i>=m || j<0 || j>=n || matrix[i][j]<=cur) return 0;
        if (memo[i][j]!=0) return memo[i][j];
        res=Math.max(res, dfs(matrix, i+1, j, memo, matrix[i][j]));
        res=Math.max(res, dfs(matrix, i-1, j, memo, matrix[i][j]));
        res=Math.max(res, dfs(matrix, i, j+1, memo, matrix[i][j]));
        res=Math.max(res, dfs(matrix, i, j-1, memo, matrix[i][j]));
        res++;
        memo[i][j]=res;
        return res;
    }
}
