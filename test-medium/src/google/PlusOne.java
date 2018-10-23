package google;
/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 12, 2018 3:13:00 PM
 */
public class PlusOne {
	
	/**
	 * very clear mind, 从低位向高位遍历，不进位的话直接返回结果，
	 * 进位的话先置该位为0， 再向高位遍历。
	 * @param digits
	 * @return
	 */

	public int[] plusOne(int[] digits) {
		for (int i = digits.length-1; i >= 0; i--) {
			if(digits[i] == 9) {
				digits[i] = 0;
				continue;
			}else {
				digits[i]++;
				return digits;
			}
		}
		int[] newNum = new int[digits.length+1];
		newNum[0] = 1;
		return newNum;       
    }
}
