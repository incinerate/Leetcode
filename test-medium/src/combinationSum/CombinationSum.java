package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * 
 * @title
 * @description Given a set of candidate numbers (C) (without duplicates) and a
 *              target number (T), find all unique combinations in C where the
 *              candidate numbers sums to T.
 * 
 *              The same repeated number may be chosen from C unlimited number
 *              of times.
 * 
 *              Note:
 * 
 *              All numbers (including target) will be positive integers. The
 *              solution set must not contain duplicate combinations.
 * 
 *              For example, given candidate set [2, 3, 6, 7] and target 7, A
 *              solution set is:
 * 
 *              [ [7], [2, 2, 3] ]
 * 
 * @author Cun Shi
 * @date: 2017��11��28�� ����3:05:58
 */
public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList)); //must new Arraylist();
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(nums, target));
	}
}
