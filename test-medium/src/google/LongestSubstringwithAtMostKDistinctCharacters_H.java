package google;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 10, 2018 4:07:41 PM
 */
public class LongestSubstringwithAtMostKDistinctCharacters_H {

	int lengthOfLongestSubstringKDistinct(String s, int k) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String sub = s.substring(i, j);
				if (sub.chars().distinct().count() == k) {
					max = Math.max(max, sub.length());
				} else if (sub.chars().distinct().count() > k) {
					break;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int res = new LongestSubstringwithAtMostKDistinctCharacters_H().lengthOfLongestSubstringKDistinct("eceaaaaab", 2);
		System.out.println(res);
	}
}
