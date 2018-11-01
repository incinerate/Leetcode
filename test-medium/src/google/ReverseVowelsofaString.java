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
	 * ˼·��������pointָ��ֱ�ָ��start��end��start�ҵ�һ��Ԫ����ͬʱend��β���ҵ�һ��Ԫ�������߽������Դ�����
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
