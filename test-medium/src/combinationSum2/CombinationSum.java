package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @title Combination Sum II
 * @description Given a collection of candidate numbers (C) and a target number
 *              (T), find all unique combinations in C where the candidate
 *              numbers sums to T.
 * 
 *              Each number in C may only be used once in the combination.
 * 
 *              Note: All numbers (including target) will be positive integers.
 *              The solution set must not contain duplicate combinations.
 *              
 *              For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target
 *              8, A solution set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * @author Cun Shi
 * @date: 2018年1月15日 下午4:58:48
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List tempList, int[] candidates, int remains, int start) {
		// TODO Auto-generated method stub
		if(remains<0) return;
		else if (remains == 0) list.add(new ArrayList<>(tempList)); 
		else {
			for (int i = start; i < candidates.length; i++) {
				if(i > start && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
				tempList.add(candidates[i]);
				backtrack(list, tempList, candidates, remains-candidates[i], i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
