package google;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 4, 2018 3:53:18 PM
 */
public class BackspaceStringCompare {

	//O(n) time and O(2n) space
	public boolean backspaceCompare1(String S, String T) {
		Stack<Character> s = new Stack<>();
		Stack<Character> t = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '#' && !s.isEmpty()) {
				s.pop();
			}else if (S.charAt(i) == '#' && s.isEmpty()) {
				continue;
			}else {
				s.push(S.charAt(i));
			}
		}
		
		for (int i = 0; i < T.length(); i++) {
			if(T.charAt(i) == '#' && !t.isEmpty()) {
				t.pop();
			}else if (T.charAt(i) == '#' && t.isEmpty()) {
				continue;
			}else {
				t.push(T.charAt(i));
			}
		}
		if(s.size()!=t.size()) return false;
		while(!s.empty()) {
			int s_pop = s.pop()-'0';
			int t_pop = t.pop()-'0';
//			System.out.println(s_pop-'0');
//			System.out.println(t_pop-'0');
			if(s_pop != t_pop)
				return false;
		}
		return true;
    }
	
	/*
	 * 思路：我们从后往前遍历，遇到'#'说明下一个字符要跳过，否则的话就继续。当所有条件满足后，此时ij必然已经递减到-1.
	 */
	
	//O(n) time and O(1) space
	public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
                back += T.charAt(j) == '#' ? 1 : -1;
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else
                return i == -1 && j == -1;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
	}
}
