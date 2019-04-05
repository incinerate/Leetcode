package google;
/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 5, 2018 5:19:17 PM
 */
public class BullsAndCows {

	//˼·:���ж�Cow����һ��trick�����num����洢ÿ�����ֳ��ֵĴ������������i��secret�г��֣�nums[s]++,��һ��ѭ��ʱ�����
	//����guess�г��֣���ʱnums[g]������һ�ֵļ����Ѿ�Ϊ1����������C++,Ȼ��nums[g]--��ͬ���������i��guess�г��֣�
	//nums[g]--,��һ��ѭ��ʱ���������secret�г��֣���ʱnums[s]������һ�ֵļ����Ѿ�Ϊ-1����������C++,Ȼ��nums[s]++.
	public String getHint(String secret, String guess) {
		int B = 0, C = 0;
		int[] nums = new int[10]; 
		for (int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				B++;
			}else {
				int s = Character.getNumericValue(secret.charAt(i));
			    int g = Character.getNumericValue(guess.charAt(i));
				if(nums[s] < 0) C++;
				if(nums[g] > 0) C++;
				nums[g]--;
				nums[s]++;
			}
		}
		return B+"A"+C+"B";
    }
}
