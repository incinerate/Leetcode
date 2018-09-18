package threeSumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Cun Shi
 *
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[nums.length-1];
		Arrays.sort(nums);
		List l = new ArrayList<Integer>();
		for (int i = 0; i < nums.length -2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] == target - nums[i]) {
					return target;
				}
				int sum = nums[j] + nums[k] + nums[i];
				if(j < k&&nums[j] + nums[k] > target - nums[i]) {
					k--;
				} else {
					j++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
			}
		}
		return result;		
	}
	
	public static void main(String[] args) {
		
		int[] nums = {0,1,2};
		System.out.println(new ThreeSumClosest().threeSumClosest(nums , 1));
	}
}
