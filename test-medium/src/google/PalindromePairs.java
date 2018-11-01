package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date: Oct 24, 2018 3:24:41 PM
 */
public class PalindromePairs {

	/*
	 * Solution1: correct but time overflow
	 */
	public List<List<Integer>> palindromePairs1(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
				if(isPalindrome(words[i],words[j])) {
					res.add(new ArrayList<>(Arrays.asList(i,j)));
				}
				if(isPalindrome(words[j],words[i])){
					res.add(new ArrayList<>(Arrays.asList(j,i)));
				}
			}
		}
		return res;
        
    }
	
	/**
	 * 方法2：首先用hashmap存每个String的index，然后找每个String中的回文subString,找到后分割，处理剩余非回文部分，
	 * 剩余部分进行一个reverse，在map中看有没有，有的话就证明匹配成功，把index加到list里面，没有继续找。
	 * @param words
	 * @return
	 */
	
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> ret = new ArrayList<>(); 
	    if (words == null || words.length < 2) return ret;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i<words.length; i++) map.put(words[i], i);
	    for (int i=0; i<words.length; i++) {
	        // System.out.println(words[i]);
	        for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);
	            if (isPalindrome(str1)) {
	                String str2rvs = new StringBuilder(str2).reverse().toString();
	                if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(map.get(str2rvs));
	                    list.add(i);
	                    ret.add(list);
	                    // System.out.printf("isPal(str1): %s\n", list.toString());
	                }
	            }
	            if (isPalindrome(str2)) {
	                String str1rvs = new StringBuilder(str1).reverse().toString();
	                // check "str.length() != 0" to avoid duplicates
	                if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(i);
	                    list.add(map.get(str1rvs));
	                    ret.add(list);
	                    // System.out.printf("isPal(str2): %s\n", list.toString());
	                }
	            }
	        }
	    }
	    return ret;
	}

	private boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length() - 1;
	    while (left <= right) {
	        if (str.charAt(left++) !=  str.charAt(right--)) return false;
	    }
	    return true;
	}

	private boolean isPalindrome(String s1, String s2) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(s1).append(s2);
		String unReverse = sb.toString();
		String reverse = sb.reverse().toString();
		return reverse.equals(unReverse);
	}
}
