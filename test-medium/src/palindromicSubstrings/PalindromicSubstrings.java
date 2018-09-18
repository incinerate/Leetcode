package palindromicSubstrings;

/**
 * Given a string, your task is to count how many palindromic substrings in this
 * string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * @author Administrator
 *
 */

public class PalindromicSubstrings {

	int count = 0;

	public int countSubstrings(String s) {
		if (s == null || s == "")
			return 0;
		for (int i = 0; i < s.length(); i++) {
			countPalindromic(s, i, i); // s.length is odd
			countPalindromic(s, i, i + 1); // s.length is even
		}
		return count;
	}

	private void countPalindromic(String s, int left, int right) {
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
	}

	public static void main(String[] args) {
		System.out.println(new PalindromicSubstrings().countSubstrings("aa"));
	}
}
