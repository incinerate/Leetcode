package differentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * 
 * Example 1:
 * 
 * Input: "2-1-1" Output: [0, 2] Explanation: ((2-1)-1) = 0 (2-(1-1)) = 2
 * Example 2:
 * 
 * Input: "2*3-4*5" Output: [-34, -14, -10, -10, 10] Explanation: (2*(3-(4*5)))
 * = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10 (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Sep 6, 2018 4:47:17 PM
 */
public class DifferentWaystoAddParentheses {

	/*
	 * 所有的运算都是基于两个数字和一个运输符，所以我把input按运算符个数分段，前后各一段再递归调用。
	 */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1List = diffWaysToCompute(part1);
				List<Integer> part2List = diffWaysToCompute(part2);
				for (Integer num1 : part1List) {
					for (Integer num2 : part2List) {
						if (input.charAt(i) == '+') {
							res.add(num2+num1);
						}else if (input.charAt(i) == '-') {
							res.add(num1-num2);
						}else if (input.charAt(i) == '*'){
							res.add(num1*num2);
						}
					}
				}
			}
		}
		if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
		return res;
	}
}
