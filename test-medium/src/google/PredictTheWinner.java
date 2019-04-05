package google;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

有没有一种选牌策略，使player1一定能赢？true：false。
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 28, 2018 10:27:57 PM
 */
public class PredictTheWinner {
	
	/*
	 * 思路：winner(nums, 0, nums.length - 1)表示player1在0-nums.length 区间内取得的最优分数（最优指player2
	 * 也是最优分数的情况下）。此时player1有两种选择，s或者e。为了使score最优，player1要尽量使player2的score小，所以max(a, b)
	 * 即为player1最优选择。
	 * 
	 * dp算法降低了时间复杂度，减少了重复子问题。原理都是一样的
	 */

	//recursive O(2^n)
	public boolean PredictTheWinner_recursive(int[] nums) {
		return winner(nums, 0, nums.length - 1) >= 0;
	}

	public int winner(int[] nums, int s, int e) {
		if (s == e)
			return nums[s];
		int a = nums[s] - winner(nums, s + 1, e);
		int b = nums[e] - winner(nums, s, e - 1);
		return Math.max(a, b);
	}
	
	//记忆化递归O(n^2) space complexity O(n^2)
	public boolean PredictTheWinner_mem(int[] nums) {
        int[][] mem = new int[nums.length][nums.length];
		return winner(nums, 0, nums.length - 1, mem) >= 0;
	}

	public int winner(int[] nums, int s, int e, int[][] mem) {
		if (s == e)
			return nums[s];
        if(mem[s][e] != 0) return mem[s][e];
		int a = nums[s] - winner(nums, s + 1, e, mem);
		int b = nums[e] - winner(nums, s, e - 1, mem);
		mem[s][e] = Math.max(a, b);
        return mem[s][e];
	}
	
	//dp(记忆化递归) O(n^2) space complexity O(n)
    public boolean PredictTheWinner_dp(int[] nums) {
    	int[] dp = new int[nums.length];
        for (int s = nums.length; s >= 0; s--) {
            for (int e = s + 1; e < nums.length; e++) {
                int a = nums[s] - dp[e];
                int b = nums[e] - dp[e - 1];
                dp[e] = Math.max(a, b);
            }
        }
        return dp[nums.length - 1] >= 0;
    }
}
