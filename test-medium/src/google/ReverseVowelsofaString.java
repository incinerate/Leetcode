package google;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * Input: "hello" Output: "holle" Example 2:
 * 
 * Input: "leetcode" Output: "leotcede"
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 31, 2018 4:16:17 PM
 */
public class ReverseVowelsofaString {

	/*
	 * 思路：用两个point指针分别指向start和end，start找到一个元音的同时end从尾部找到一个元音，两者交换。以此类推
	 */
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return s;
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {

			while (start < end && !vowels.contains(chars[start] + "")) {
				start++;
			}

			while (start < end && !vowels.contains(chars[end] + "")) {
				end--;
			}

			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;

			start++;
			end--;
		}
		return new String(chars);
	}
}
