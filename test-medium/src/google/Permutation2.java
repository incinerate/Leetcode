package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 16, 2018 5:17:20 PM
 */
public class Permutation2 {

	/*
	 * ˼·�����ڲ����ظ���permutation����һ����Ҫ��Array���򣻵ڶ��������ظ�����˳�����ң�����112����һ��1ʼ��Ҫ�ڵڶ���1ǰ�棬
	 * ������112,121,211. ����1��˳���ܱ䣬��Ҳ���ж�����!visited[i - 1]��magic֮����
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		createPermutation(res, l, nums, visited);

		return res;

	}

	private void createPermutation(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited) {

		if (list.size() == nums.length)
			res.add(new LinkedList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (visited[i])
					continue;
				if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])
					continue;
				list.add(nums[i]);
				visited[i] = true;
				createPermutation(res, list, nums, visited);
				list.removeLast();
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(new Permutation2().permuteUnique(nums));
	}
}
