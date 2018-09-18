package singleNumberII;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,3,2] Output: 3 Example 2:
 * 
 * Input: [0,1,0,1,0,1,99] Output: 99
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Sep 17, 2018 5:54:08 PM
 */
public class SingleNumberII {

	public int singleNumber(int[] nums) {
		int[] disArr = Arrays.stream(nums).distinct().toArray();
		for (int i : disArr) {
			if(Arrays.stream(nums).filter(p -> p == i).count() == 1)
				return i;
		}
		return 0;

	}
}
