package jumpGameII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author Scott Shi
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
		
		int res = 0;
	    int end = 0;
	    int range = 0;
	    for(int i=0; i<nums.length-1; i++) {
	        range = Math.max(range, i+nums[i]);
	        if( i == end ) {
	            res++;
	            end = range;
	        } 
	    }
	    return res;

	}
}
