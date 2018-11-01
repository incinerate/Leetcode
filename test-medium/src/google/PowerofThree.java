package google;

import java.math.BigInteger;

/**
 * Given an integer, write a function to determine if it is a power of three.

Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 31, 2018 5:38:27 PM
 */
public class PowerofThree {

	public static boolean isPowerOfThree(int n) {
		// 1162261467 is 3^19,  3^20 is bigger than int  
	    return ( n>0 &&  1162261467%n==0);
    }
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(3));
	}
}
