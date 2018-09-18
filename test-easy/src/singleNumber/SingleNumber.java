package singleNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author Administrator
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result^nums[i];
		}
		return result;
	}

	/*
	 * we use bitwise XOR to solve this problem :
	 * 
	 * first , we have to know the bitwise XOR in java
	 * 
	 * 0 ^ N = N N ^ N = 0 So..... if N is the single number
	 * 
	 * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
	 * 
	 * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
	 * 
	 * = 0 ^ 0 ^ ..........^ 0 ^ N
	 * 
	 * = N
	 */
}
