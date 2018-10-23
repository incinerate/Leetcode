package google;
/**
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 19, 2018 9:15:20 PM
 */
public class KEmptySlots {

	/**
	 * 1.从left到right是一个固定长度为k的区间，我们要保证区间内的bloom day要晚于left和right，这样才保证区间内有k朵花
	 * 在rightday是没有开放，满足题意
	 * 
	 * 2.一开始i==left=0, 如果(i+1)位置的花已经开放，那么更新left和right的位置；
	 * 如果没有开放，那么i++, left和rihgt不变，直到某时刻i==right，说明区间中已经有k朵花在第i(right)天没有开放，返回结果
	 * @param flowers
	 * @param k
	 * @return
	 */
	public int kEmptySlots(int[] flowers, int k) {
		int left = 0, right = k + 1, res = Integer.MAX_VALUE;
		int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1; 
		for (int i = 0; right < flowers.length; i++) {
			 if(days[i] < days[left] || days[i] <= days[right]){
	                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
	                left = i; 
	                right = k + 1 + i;
	            }
		}
		return (res == Integer.MAX_VALUE)?-1:res;
        
    }
	
	public static void main(String[] args) {
		int[] flowers = {1,4,3,2};
		System.out.println(new KEmptySlots().kEmptySlots(flowers, 1));
	}
}
