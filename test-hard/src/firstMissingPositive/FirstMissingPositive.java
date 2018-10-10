package firstMissingPositive;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Scott Shi
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		int j = 1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<=0) continue;
			else if(i>0 && nums[i] == nums[i-1]) continue;
			else if(nums[i] == j) j++;
			else return j;
		}
		return j;
	}
}
