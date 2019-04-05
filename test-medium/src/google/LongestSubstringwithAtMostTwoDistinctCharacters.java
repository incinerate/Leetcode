package google;

import java.util.HashMap;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 1, 2018 5:35:15 PM
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
	
	/*
	 * 思路： 此处为Sliding Window的HashMap 标准解法，对于相似问题都可借鉴。
	 * 首先用hashmap存储string中的character，如果hashmap的size大于2，此时需要比较max，然后移动
	 * window的左界限（start with 0），直到map中有character的frequency为0，此时删除
	 * frequency为0的character，继续移动window的右边界，直到右边界到达最后一个character。
	 * 
	 * hashmap并不是最快的方案，最快solution见 LongestSubstringwithAtMostKDistinctCharacters方法
	 * 
	 */

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			}else {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}
			while(map.size() > 2) {
				map.put(s.charAt(j), map.get(s.charAt(j))-1);
				if(map.get(s.charAt(j)) == 0) {
					map.remove(s.charAt(j));
				}
				j++;
			}
			int temp = 0;
			for (int v : map.values()) {
				temp += v;
			};
			
			max = Math.max(max, temp);
		}
		return max;
        
    }
}
