package longestConsecutiveSequence;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive
 * elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author Scott Shi
 *
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		if(nums.length == 0) return 0;
		
		int[] new_nums = Arrays.stream(nums).distinct().sorted().toArray();
		
		int max = 1;
		int res = 1;
		for (int i = 0; i < new_nums.length -1; i++) {
			if(new_nums[i]==new_nums[i+1] - 1) {
				max++;
				res = Math.max(max, res);
			}else {
				res = Math.max(max, res);
				max = 1;
			}
		}
		return res;

	}
	
	public static void main(String[] args) {
		int[] a = {0,-1};
		new LongestConsecutiveSequence().longestConsecutive(a);
	}
}
