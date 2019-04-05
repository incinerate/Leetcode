package google;

import java.util.HashSet;

/**
 * 
There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.

You can keep inputting the password, the password will automatically be matched against the last n digits entered.

For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.

Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.

Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.
Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.
Note:
n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 30, 2018 4:05:13 PM
 */
public class CrackingTheSafe {

	/*
	 * 思路：此题的精髓在于reuse前面n-1长度的字符串，加上i构成新的string，看visited中有没有，有了就回溯，没有的话就
	 * dfs，直到找到全部你n^k种组合为止。
	 */
	public String crackSafe(int n, int k) {
		int total = (int) Math.pow(k, n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) sb.append('0');
		HashSet<String> visited = new HashSet<>();
		visited.add(sb.toString());
		
		dfs(sb, total, visited, n, k);
		return sb.toString();
        
    }

	private boolean dfs(StringBuilder sb, int total, HashSet<String> visited, int n, int k) {
		if(visited.size() == total) return true;
		String prev = sb.substring(sb.length()-n+1);
		for (int i = 0; i < k; i++) {
			String next = prev + i;
			if(!visited.contains(next)) {
				visited.add(next);
				sb.append(i);
				if(dfs(sb, total, visited, n, k)) return true;
				//说明是死路一条，backtrack.
				sb.delete(sb.length()-1, sb.length());
				visited.remove(next);
			}
		}
		return false;
	}
}
