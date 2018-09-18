package validAnagram;

import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true 
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Sep 17, 2018 5:43:05 PM
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) return false;
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++) {
			if(c1[i] == c2[i]) continue;
			else return false;
		}
		return true;

	}
}
