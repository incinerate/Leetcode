package permutations2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	For example,
	[1,1,2] have the following unique permutations:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
 * @author Scott Shi
 *
 */
public class Permutations2 {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
		createPermutation(res,l,nums,visited);
		
		return res;

	}

	private void createPermutation(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited) {
		
		if(list.size()==nums.length)
			res.add(new LinkedList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				if(visited[i]) continue;
                if(i>0 &&nums[i-1]==nums[i] && !visited[i-1]) continue;
				list.add(nums[i]);
				visited[i] = true;
				createPermutation(res, list, nums, visited);	
				list.removeLast();
				visited[i] = false;
			}
		}
    }
}
