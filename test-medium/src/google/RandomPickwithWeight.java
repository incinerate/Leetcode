package google;

import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Jan 27, 2019 5:15:47 PM
 */
public class RandomPickwithWeight {
	
	/*
	 * 思路，用一个random函数，看r落在那个区间，决定picKIndex的结果。
	 */

	// My AC answer
	public int[] weight;
	public Random r;
	public int sum;

	public RandomPickwithWeight(int[] w) {
		this.weight = w;
		for (int e : w) {
			sum += e;
		}
		r = new Random();
	}

	// O(n)
	public int pickIndex() {
		int rand = r.nextInt(sum);
		int i = 0;
		while (rand >= 0) {
			rand -= weight[i];
			++i;
		}
		return i - 1;
	}

	// Opt Answer
	Random random;
	int[] wSums;

	public void RandomPickwithWeight_OPT(int[] w) {
		this.random = new Random();
		for (int i = 1; i < w.length; ++i)
			w[i] += w[i - 1];
		this.wSums = w;
	}

	// O(logn)
	public int pickIndex_() {
		int len = wSums.length;
		int idx = random.nextInt(wSums[len - 1]) + 1;
		int left = 0, right = len - 1;
		// search position
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (wSums[mid] == idx)
				return mid;
			else if (wSums[mid] < idx)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}
