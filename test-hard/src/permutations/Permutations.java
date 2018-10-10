package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author Scott Shi
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		createPermutation(res,l,nums);
		
		return res;

	}

	private void createPermutation(List<List<Integer>> res, LinkedList<Integer> list, int[] nums) {
		
		if(list.size()==nums.length)
			res.add(new LinkedList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				if(list.contains(nums[i])) continue;
				list.add(nums[i]);
				createPermutation(res, list, nums);	
				list.removeLast();
			}
		}
	}
}
