package google;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 15, 2018 7:18:25 PM
 */
public class PerfectSquares {

	public int numSquares(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++) {
			if((Math.sqrt(i)) % 1 == 0) {
				
				dp[i] = 1;
			}
			else {
				int p = 1;
				int q = i-1;
				while(q>=p) {
					dp[i] = Math.min(dp[i], dp[q] + dp[p]);
					p++;
					q--;
				}
			}
		}
		return dp[n];
    }
	
	public int numSquares1(int n) {
		LinkedList<Integer> dp = new LinkedList<Integer>();
		dp.addFirst(0);
		while(dp.size()<=n) {
			int min = Integer.MAX_VALUE;
			for (int i = 1; i*i <= dp.size(); i++) {
				min = Math.min(min, dp.get(dp.size()-i*i) + 1);
			}
			dp.add(min);
		}
		return dp.get(n);
    }
	
	public static void main(String[] args) {
		System.out.println( new PerfectSquares().numSquares1(14));
	}
}
