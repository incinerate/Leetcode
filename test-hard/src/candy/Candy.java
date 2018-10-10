package candy;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
             
 * @author Scott Shi
 * 
 */
public class Candy {

	/*
	 * 思路：正着来一遍，反着来一遍，这时所有的孩子都拿到了应得的candy
	 */
	public int candy(int[] ratings) {
		if(ratings.length==1) return 1;
		int n = ratings.length;
		int[] candies = new int[n];
		Arrays.fill(candies, 1);
		for (int i = 1; i < candies.length; i++) {
			if(ratings[i] > ratings[i-1])
				candies[i] = candies[i-1] + 1;
		}
		int sum = candies[n-1];
		for (int i = n-1; i > 0; i--) {
			if(ratings[i-1] > ratings[i])
				candies[i-1] = Math.max(candies[i-1], candies[i]+1);
			sum+=candies[i-1];
		}
		return sum;
        
    }
}
