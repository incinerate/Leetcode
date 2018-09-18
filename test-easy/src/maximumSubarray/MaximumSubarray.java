package maximumSubarray;

import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6. Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * @author Scott Shi
 *
 */
public class MaximumSubarray {

	/*
	 * 超级神奇的算法，值得铭记一生
	 * O(n)复杂度，需要找到遍历到i位置时的MaxEnding，可以是一个A[i],也可以是一个subArray，然后在和现在的maxSubArray
	 * 比较得到最大的subArray,如果把maxEndingHere换成dp[],他就是dp解法了。
	 */
	public int maxSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	/*
	 * dp算法
	 */
	public int maxSubArray_DP(int[] nums) {
		int[] dp = new int[nums.length-1];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
