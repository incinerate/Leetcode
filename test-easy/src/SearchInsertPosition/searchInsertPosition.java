package SearchInsertPosition;

import java.util.Arrays;

/**
 * 
 * @title Search Insert Position
 * @description Given a sorted array and a target value, return the index if the
 *              target is found. If not, return the index where it would be if
 *              it were inserted in order.
 * 
 *              You may assume no duplicates in the array
 * @author Cun Shi
 * @date: 2017年11月14日 下午3:23:52
 */
public class searchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		return Arrays.binarySearch(nums, target) >= 0 ? Arrays.binarySearch(
				nums, target) : -1 - Arrays.binarySearch(nums, target);
	}
}
