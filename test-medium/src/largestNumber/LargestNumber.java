package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * Input: [10,2] Output: "210" Example 2:
 * 
 * Input: [3,30,34,5,9] Output: "9534330" Note: The result may be very large, so
 * you need to return a string instead of an integer.
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Sep 17, 2018 3:45:13 PM
 */
public class LargestNumber {

	public String largestNumber(int[] nums) {
		
		if(nums == null || nums.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_nums = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
		    s_nums[i] = String.valueOf(nums[i]);
		
		Arrays.sort(s_nums, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				String str1 = s1+s2;
				String str2 = s2+s1;
				return str2.compareTo(str1);
			}
		});
		
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_nums[0].charAt(0) == '0')
            return "0";
        
		StringBuilder sb = new StringBuilder();
		for(String s: s_nums)
	            sb.append(s);
		
		return sb.toString();

	}
	
	//3 line java8 solution
	public String brilliant(int[] num) {
		String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
	}
	
	public static void main(String[] args) {
		System.out.println((Integer.lowestOneBit(6)));
	}
}
