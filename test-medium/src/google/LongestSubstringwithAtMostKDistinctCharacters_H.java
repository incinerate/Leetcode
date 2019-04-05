package google;

import java.util.HashMap;

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

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, cntDif = 0;
        int[] map = new int[256];
        int result = 0;

        for (int r = 0; r < s.length(); r++) {
            map[s.charAt(r)]++;
            if (map[s.charAt(r)] == 1) {
                cntDif++;
            }
            if (cntDif <= k) {
                result = Math.max(result, r - l + 1);
            }
            while (cntDif > k) {
                map[s.charAt(l)]--;
                if (map[s.charAt(l)] == 0) {
                    cntDif--;
                }
                l++;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int res = new LongestSubstringwithAtMostKDistinctCharacters_H().lengthOfLongestSubstringKDistinct("eceaaaaab", 2);
		System.out.println(res);
	}
}
