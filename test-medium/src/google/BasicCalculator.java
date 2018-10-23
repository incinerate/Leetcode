package google;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 22, 2018 6:40:41 PM
 */
public class BasicCalculator {

	public int calculate(String s) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int result = 0;
	    int number = 0;
	    int sign = 1;
	    for(int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	        	//Convert the character into actual number
	            number = 10 * number + (int)(c - '0');//Could be more than 1 character digit hence we need to shift
	        }else if(c == '+'){
	            result += sign * number;
	            number = 0;//Reset the number 
	            sign = 1;
	        }else if(c == '-'){
	            result += sign * number;
	            number = 0;//We are going to read a new number
	            sign = -1;
	        }else if(c == '('){
	            //we push the result first, then sign;
	            stack.push(result);
	            stack.push(sign);
	            //reset the sign and result for the value in the parenthesis
	            sign = 1;   
	            result = 0;
	        }else if(c == ')'){
	        	//Done with this lower level state, so get restore previous state results and combine them
	            result += sign * number;  
	            number = 0;
	            result *= stack.pop();    //stack.pop() is the sign before the parenthesis
	            result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
	            
	        }
	    }
	    //Don't forget the last number
	    if(number != 0) result += sign * number;
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new BasicCalculator().calculate("1+3+(2-1)"));
	}
}
