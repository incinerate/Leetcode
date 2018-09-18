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
	 * ����������㷨��ֵ������һ��
	 * O(n)���Ӷȣ���Ҫ�ҵ�������iλ��ʱ��MaxEnding��������һ��A[i],Ҳ������һ��subArray��Ȼ���ں����ڵ�maxSubArray
	 * �Ƚϵõ�����subArray,�����maxEndingHere����dp[],������dp�ⷨ�ˡ�
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
	 * dp�㷨
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
