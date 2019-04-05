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
	 * ˼·�� �˴�ΪSliding Window��HashMap ��׼�ⷨ�������������ⶼ�ɽ����
	 * ������hashmap�洢string�е�character�����hashmap��size����2����ʱ��Ҫ�Ƚ�max��Ȼ���ƶ�
	 * window������ޣ�start with 0����ֱ��map����character��frequencyΪ0����ʱɾ��
	 * frequencyΪ0��character�������ƶ�window���ұ߽磬ֱ���ұ߽絽�����һ��character��
	 * 
	 * hashmap���������ķ��������solution�� LongestSubstringwithAtMostKDistinctCharacters����
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
