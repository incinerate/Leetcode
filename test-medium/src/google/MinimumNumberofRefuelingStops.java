package google;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberofRefuelingStops {
	
	/*
	 * 思路：因为每路过一个station，可以选择加油或者不加油，只要cur的油量大于到本站所花费的油量。
	 * 
	 * 在PQ方法中，如果油量不够(s[i][0] <= cur)，就从pq中poll出能加油最多的路过的station，然后res++进入下一个for loop
	 * 直到cur>=target，即可以跑到终点，返回res。
	 * 
	 * dp方法中，dp[i]指经过i个station最多能跑的里程数
	 */

	//PriorityQueue 方法
	public int minRefuelStops_pq(int target, int cur, int[][] s) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res;
        for (res = 0; cur < target; res++) {
            while (i < s.length && s[i][0] <= cur)
                pq.offer(-s[i++][1]);
            if (pq.isEmpty()) return -1;
            cur += -pq.poll();
        }
        return res;
    }
	
	//dp
	public int minRefuelStops_dp(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < s.length; ++i)
            for (int t = i; t >= 0 && dp[t] >= s[i][0]; --t)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
        for (int t = 0; t <= s.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
}
