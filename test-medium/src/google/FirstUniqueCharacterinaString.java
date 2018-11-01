package google;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 24, 2018 3:04:33 PM
 */
public class FirstUniqueCharacterinaString {
	
	/*
	 * 思路：因为你不遍历到最后一位，就无法找到第一个unique的char,所以我们先统计所有char的频率，
	 * 然后再遍历一次s,确定第一个unique的char
	 */

	 public int firstUniqChar(String s) {
	        int freq [] = new int[26];
	        for(int i = 0; i < s.length(); i ++)
	            freq [s.charAt(i) - 'a'] ++;
	        for(int i = 0; i < s.length(); i ++)
	            if(freq [s.charAt(i) - 'a'] == 1)
	                return i;
	        return -1;
	    }
}
