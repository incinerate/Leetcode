package validParentheses;

import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(isValid("({})"));
	}

	public static boolean isValid(String s) {
		char[] array = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : array) {
			if(c=='(')
				stack.push(')');
			else if(c=='[')
				stack.push(']');
			else if(c=='{')
				stack.push('}');
			else if(stack.isEmpty() || stack.pop()!=c)
				return false;
		}
		return stack.isEmpty();
	}
}
