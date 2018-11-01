package google;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can
 * return either index number 1 where the peak element is 2, or index number 5
 * where the peak element is 6.
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 28, 2018 9:57:30 PM
 */
public class FindPeekElement {
	/*
	 * 思路：logn的算法复杂度只能用Binary Search去解，首先，如果一个数的左边比它大，那么peak number一定在这个数左侧，
	 * 同理右边也一样。所以我们可以用binary search解。
	 */

	// Need O(log n) time complexity
	public int findPeakElement(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public int helper(int[] num, int start, int end) {
		if (start == end) {
			return start;
		} else if (start + 1 == end) {
			if (num[start] > num[end])
				return start;
			return end;
		} else {

			int m = (start + end) / 2;

			if (num[m] > num[m - 1] && num[m] > num[m + 1]) {

				return m;

			} else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {

				return helper(num, start, m - 1);

			} else {

				return helper(num, m + 1, end);

			}

		}
	}
}
