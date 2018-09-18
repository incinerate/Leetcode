package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @title Group Anagrams
 * @description Given an array of strings, group anagrams together.
 * 
 *              For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *              Return:
 * 
 *              [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 * @author Cun Shi
 * @date: 2018年1月24日 下午3:35:08
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) 
			return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) 
            	map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
	}
}
