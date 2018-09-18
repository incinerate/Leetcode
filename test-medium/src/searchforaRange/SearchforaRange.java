package searchforaRange;

import java.util.Arrays;

/**
 * 
 * @title Search for a Range
 * @description Given an array of integers sorted in ascending order, find the
 *              starting and ending position of a given target value.
 * 
 *              Your algorithm's runtime complexity must be in the order of
 *              O(log n).
 * 
 *              If the target is not found in the array, return [-1, -1].
 * 
 *              For example, Given [5, 7, 7, 8, 8, 10] and target value 8,
 *              return [3, 4].
 * @author Cun Shi
 * @date: 2017年11月9日 下午9:56:34
 */
public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int start = -1;
		int end = -1;
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		end = Arrays.binarySearch(nums, target) > -1 ? Arrays.binarySearch(
				nums, target) : -1;
		System.out.println(end);
		while (end != -1 && end != nums.length - 1
				&& nums[end] == nums[end + 1]) {
			end++;
		}
		if (end != -1) {
			for (int i = end; i >= 0; i--) {
				if (nums[i] == nums[end])
					start = i;
			}
		}

		int[] res = { start, end };
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2 };
		System.out.println(Arrays.toString(new SearchforaRange().searchRange(
				nums, 3)));
	}
}
