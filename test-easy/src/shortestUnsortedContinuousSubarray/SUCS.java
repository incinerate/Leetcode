package shortestUnsortedContinuousSubarray;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SUCS {
	public static void main(String[] args) {
		int[] nums = {3,1};
		System.out.println(findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
		if (nums.length <= 1)
			return 0;
		int[] newNums = Arrays.copyOf(nums, nums.length);
		List<Integer> l = new ArrayList<Integer>();
		Arrays.sort(newNums);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != newNums[i]){
				l.add(i);
			}
		}
		if(l.isEmpty())
			return 0;
		return Collections.max(l)-Collections.min(l)+1;
	}
}
