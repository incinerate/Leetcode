package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * @author Cun Shi
 *
 */
public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i + 3 < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}
			J:for (int j = i + 1; j < nums.length - 2; j++) {
				int k = j + 1, l = nums.length - 1;
				if (j > i + 1 && nums[j] == nums[j - 1]) { // skip same result
					continue J;
				}
				while (k < l) {
					if (nums[i] + nums[j] + nums[l] + nums[k] == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[k],
								nums[l]));
						k++;
						l--;
						while (k < l && nums[k] == nums[k - 1])
							k++; // skip same result
						while (k < l && nums[l] == nums[l + 1])
							l--; // skip same result
					} else if (nums[i] + nums[j] + nums[l] + nums[k] > target) {
						l--;
					} else {
						k++;
					}
				}
			}
		}
		return res;
		
	}
}
