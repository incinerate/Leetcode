package google;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberofRefuelingStops {
	
	/*
	 * ˼·����Ϊÿ·��һ��station������ѡ����ͻ��߲����ͣ�ֻҪcur���������ڵ���վ�����ѵ�������
	 * 
	 * ��PQ�����У������������(s[i][0] <= cur)���ʹ�pq��poll���ܼ�������·����station��Ȼ��res++������һ��for loop
	 * ֱ��cur>=target���������ܵ��յ㣬����res��
	 * 
	 * dp�����У�dp[i]ָ����i��station������ܵ������
	 */

	//PriorityQueue ����
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
