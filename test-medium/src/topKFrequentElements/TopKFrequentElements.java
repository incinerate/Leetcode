package topKFrequentElements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 11, 2018 5:17:58 PM
 */
public class TopKFrequentElements {

	/*
	 * 思路，先用hashmap存储nums中的所有数据，然后在用1.8新特性sort大列表，按翻译的频率排序。
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if(map.containsKey(i)) {
				map.replace(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}
		List<Integer> list = map.entrySet().stream()
		            .sorted((Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> o2.getValue() - o1.getValue())
		            .map(entry -> entry.getKey()).collect(Collectors.toList())
		            .subList(0, k);
		return list;
        
    }
}
