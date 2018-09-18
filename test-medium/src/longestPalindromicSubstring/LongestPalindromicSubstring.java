package longestPalindromicSubstring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * @author Scott
 *
 */
public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		if(s.length()<=1) return s;
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		for (int i = 0; i < s.length(); i++) {
			String palindromeOdd = findPalindrome(s, i, i);
			String palindromeEven = findPalindrome(s, i, i + 1);
			if (palindromeOdd != "") {
				hm.put(palindromeOdd.length(), palindromeOdd);
			}
			if (palindromeEven != "") {
				hm.put(palindromeEven.length(), palindromeEven);
			}
		}
		Integer max = Collections.max(hm.keySet());
		return hm.get(max);
	}

	private static String findPalindrome(String s, int left, int right) {
		String substr = "";
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else {			
				break;
			}
		}
		substr = s.substring(left+1, right);
		System.out.println(substr);
		return substr;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abam"));
	}
}
