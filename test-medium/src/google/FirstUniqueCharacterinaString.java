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
	 * ˼·����Ϊ�㲻���������һλ�����޷��ҵ���һ��unique��char,����������ͳ������char��Ƶ�ʣ�
	 * Ȼ���ٱ���һ��s,ȷ����һ��unique��char
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
