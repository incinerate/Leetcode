package nextPermutation;

import java.util.Arrays;

/**
 * 
 * @title Next Permutation
 * @description Implement next permutation, which rearranges numbers into the
 *              lexicographically next greater permutation of numbers.
 * 
 *              If such arrangement is not possible, it must rearrange it as the
 *              lowest possible order (ie, sorted in ascending order).
 * 
 *              The replacement must be in-place, do not allocate extra memory.
 * 
 *              Here are some examples. Inputs are in the left-hand column and
 *              its corresponding outputs are in the right-hand column. 
 *              1,2,3 → 1,3,2 
 *              3,2,1 → 1,2,3 
 *              1,1,5 → 1,5,1
 * @author Cun Shi
 * @date: 2017年11月8日 下午8:46:39
 */
public class NextPermutation {

	public int[] nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int temp;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] < nums[i]) {
				continue;
			} else {
				temp = nums[i];
				for (int j = nums.length - 1; j >= i; j--) {
					if (temp < nums[j]) {
						nums[i] = nums[j];
						nums[j] = temp;
						reverse(nums, i + 1);
						return nums;
					}
				}
			}
		}
		reverse(nums, 0);
		return nums;
	}

	private void reverse(int[] num, int index) {
		int l = index;
		int r = num.length - 1;
		while (l < r) {
			int temp = num[l];
			num[l] = num[r];
			num[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1 };
		System.out.println(Arrays.toString(new NextPermutation()
				.nextPermutation(nums)));
	}
}
