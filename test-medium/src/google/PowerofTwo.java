package google;

import java.math.BigInteger;

/**
 * Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 2^0 = 1
Example 2:

Input: 16
Output: true
Explanation: 2^4 = 16
Example 3:

Input: 218
Output: false

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 31, 2018 3:38:27 PM
 */
public class PowerofTwo {

	/*
	 * Power of 2 means only one bit of n is '1', 
	 * so use the trick n&(n-1)==0 to judge whether that is the case
	 */
	public boolean isPowerOfTwo(int n) {
//		return n>0? Integer.bitCount(n)==1:false;
		return n > 0 && ((n & (n-1)) == 0);
    }
	
	public static void main(String[] args) {
		System.out.println(new PowerofTwo().isPowerOfTwo(-256));
	}
}
