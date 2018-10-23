package google;

import java.util.LinkedList;

/**
 * You are given a license key represented as a string S which consists only
 * alphanumeric character and dashes. The string is separated into N+1 groups by
 * N dashes.
 * 
 * Given a number K, we would want to reformat the strings such that each group
 * contains exactly K characters, except for the first group which could be
 * shorter than K, but still must contain at least one character. Furthermore,
 * there must be a dash inserted between two groups and all lowercase letters
 * should be converted to uppercase.
 * 
 * Given a non-empty string S and a number K, format the string according to the
 * rules described above.
 * 
 * Example 1: Input: S = "5F3Z-2e-9-w", K = 4
 * 
 * Output: "5F3Z-2E9W"
 * 
 * Explanation: The string S has been split into two parts, each part has 4
 * characters. Note that the two extra dashes are not needed and can be removed.
 * Example 2: Input: S = "2-5g-3-J", K = 2
 * 
 * Output: "2-5G-3J"
 * 
 * Explanation: The string S has been split into three parts, each part has 2
 * characters except the first part as it cou
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 10, 2018 5:45:21 PM
 */
public class LicenseKeyFormmating {

	/**
	 * 此题用stringbuilder做会更快，思路是先去‘-’，然后一个一个拼接，加‘-’，最后reverse一下
	 * @param S
	 * @param K
	 * @return
	 */
	public String licenseKeyFormatting(String S, int K) {
		S = S.replace("-", "");
		int len = S.length();
		LinkedList<String> l = new LinkedList<>();
		while(len>=K) {
			l.addFirst(S.substring(len-K, len).toUpperCase());
			len -= K;
		}
        if(len>0) l.addFirst(S.substring(0, len).toUpperCase());
		return String.join("-", l);

	}
}
