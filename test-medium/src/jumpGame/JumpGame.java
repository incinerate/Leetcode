/**
 * 
 */
package jumpGame;

import java.util.Arrays;

/**
 * @title jumpGame
 * @description Given an array of non-negative integers, you are initially
 *              positioned at the first index of the array.
 * 
 *              Each element in the array represents your maximum jump length at
 *              that position.
 * 
 *              Determine if you are able to reach the last index.
 * 
 *              For example: A = [2,3,1,1,4], return true.
 * 
 *              A = [3,2,1,0,4], return false.
 * @author Cun Shi
 * @date: 2018年3月4日 下午8:25:00
 */
public class JumpGame {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(new JumpGame().canJump(nums));
	}

	public boolean canJump(int[] nums) {
		int maxLocation = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxLocation < i)
				return false; // if previous maxLocation smaller than i, meaning we cannot reach location i,
								// thus return false.
			maxLocation = (i + nums[i]) > maxLocation ? i + nums[i] : maxLocation; // greedy:
		}
		return true;
	}
}
