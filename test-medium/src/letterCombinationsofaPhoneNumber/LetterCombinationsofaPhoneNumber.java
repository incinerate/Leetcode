package letterCombinationsofaPhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * @author Cun Shi
 *
 */
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> res = new LinkedList<String>();
		res.add("");
		if (digits.isEmpty()) {
			res.clear();
			return res;
		}
		String[][] arr = { { "0" }, { "1" }, { "a", "b", "c" },
				{ "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" },
				{ "w", "x", "y", "z" } };
		char[] charArray = digits.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int index = Integer.parseInt(String.valueOf(charArray[i]));
			while (res.peek().length() == i) {
				String r = res.remove(); // !!¾«Ëè
				for (String s : arr[index]) {
					res.add(r + s);
				}
			}
		}
		System.out.println(res);
		return res;

	}

	public static void main(String[] args) {
		new LetterCombinationsofaPhoneNumber().letterCombinations("");
	}
}
