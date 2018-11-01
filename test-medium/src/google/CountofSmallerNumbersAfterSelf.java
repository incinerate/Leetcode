package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 29, 2018 4:37:19 PM
 */
public class CountofSmallerNumbersAfterSelf {

	/**
	 * 思路：从最后一个元素找起，如果sorted list为空就返回0，将该元素加入sorted，从小到大排列；不为空就找到该元素该加入的位置，
	 * 返回index。由于sorted存的是历史，所以index即为该要的结果，放入res[i].
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmaller(int[] nums) {
	    Integer[] res = new Integer[nums.length];
	    List<Integer> sorted = new ArrayList<Integer>();
	    for (int i = nums.length - 1; i >= 0; i--) {
	        int index = findIndex(sorted, nums[i]);
	        res[i] = index;
	        sorted.add(index, nums[i]);
	    }
	    return Arrays.asList(res);
	}
	private int findIndex(List<Integer> sorted, int target) {
	    if (sorted.size() == 0) return 0;
	    int start = 0;
	    int end = sorted.size() - 1;
	    if (sorted.get(end) < target) return end + 1;
	    if (sorted.get(start) >= target) return 0;
	    //binary search, return the index which res[index-1]<res[index]<res[index+1]
	    while (start + 1 < end) {
	        int mid = start + (end - start) / 2;
	        if (sorted.get(mid) < target) {
	            start = mid + 1;
	        } else {
	            end = mid;
	        }
	    }
	    if (sorted.get(start) >= target) return start;
	    return end;
	}
}
