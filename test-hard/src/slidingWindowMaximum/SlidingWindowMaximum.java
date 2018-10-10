package slidingWindowMaximum;

import java.util.Collections;
import java.util.LinkedList;
/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 * @author Scott Shi
 *
 */
public class SlidingWindowMaximum {

	/*
	 * 思路是用一个Linkedlist去维护Window里面的东西，用于找最大值
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 1)
			return nums;
		int[] res = new int[nums.length - k + 1];

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			list.add(nums[i]);
		}
		list.sort((Integer i1, Integer i2) -> (i1 - i2));
		res[0] = list.getLast();
		for (int i = k; i < nums.length; i++) {
			list.remove((Object) nums[i - k]);
			list.add(nums[i]);
			Collections.sort(list);
			res[i - k + 1] = list.getLast();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		new SlidingWindowMaximum().maxSlidingWindow(nums, 3);
	}
}
