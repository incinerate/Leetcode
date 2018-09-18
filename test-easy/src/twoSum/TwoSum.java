package twoSum;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 3, 3 };
		int target = 6;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	/**
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n^2). For each element, we try to find its
	 * complement by looping through the rest of array which takes O(n)
	 * time. Therefore, the time complexity is O(n^2).
	 * 
	 * Space complexity : O(1).
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		// int[] con = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1 + i; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					// con[0] = i;
					// con[1] = j;
					// return con;
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
