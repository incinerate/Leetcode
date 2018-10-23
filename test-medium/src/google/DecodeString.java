package google;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 11, 2018 7:11:47 PM
 */
public class DecodeString {

	/**
	 * 利用stack存储中括号，发现[pust，发现]pop，递归调用Decode函数，即可得到答案。注意数字可以是多位数
	 * @param s
	 * @return
	 */
	Stack<Integer> stack = new Stack<>();
	public String decodeString(String s) {
			if(!s.contains("["))
				return s;
		
			
			int j ;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '[') {
					stack.push(i);
				}
				if (s.charAt(i) == ']') {
					StringBuilder res = new StringBuilder();
					StringBuilder num = new StringBuilder();
					j = stack.pop();
					int j1 = j;
					while(j1!=0 && Character.isDigit(s.charAt(j1-1))) {
						num.append(s.charAt(j1-1));
						j1--;
					}
					res.append(s.substring(0, j1));
					int total = Integer.valueOf(num.reverse().toString());
					for (int k = 0; k < total; k++) {
						String temp = decodeString(s.substring(j+1, i));
						res.append(temp);
					}
					res.append(s.substring(i+1));
					s = res.toString();
					s = decodeString(s);
				}
			}
			return s;
	    }
	
	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("100[leetcode]"));
	}
}
