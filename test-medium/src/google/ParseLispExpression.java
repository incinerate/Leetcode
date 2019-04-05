package google;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {

	public int evaluate(String expression) {
		return eval(expression, new HashMap<>());
	}

	private int eval(String e, Map<String, Integer> scopes) {
		if (e.startsWith("(")) { // drop surrounding ( )
			return eval(e.substring(1, e.length() - 1), scopes);
		} else if (e.startsWith("let")) {
			String letExpr = e.substring(4);
			int split = getLetSplit(letExpr); // 'let split' is a point where params end and last expression begins
			return eval(letExpr.substring(split + 1), parsescopes(scopes, letExpr.substring(0, split)));
		} else if (e.startsWith("add")) {
			String addExpr = e.substring(4);
			int split = getSplit(addExpr); // to split add elements
			return eval(addExpr.substring(0, split), scopes) + eval(addExpr.substring(split + 1), scopes);
		} else if (e.startsWith("mult")) { // to split mult elements
			String multExpr = e.substring(5);
			int split = getSplit(multExpr);
			return eval(multExpr.substring(0, split), scopes) * eval(multExpr.substring(split + 1), scopes);
		} else {
			return getVal(scopes, e); // converts expression to Integer if it's a number or looks up value in map
		}
	}

	private int getSplit(String e) { // to split components of add and mult
		if (e.startsWith("(")) { // if we are dealing with another expression
			int count = 1;
			int idx = 1;
			while (count != 0) {
				if (e.charAt(idx) == '(')
					count++;
				else if (e.charAt(idx) == ')')
					count--;
				idx++;
			}
			return idx;
		} else { // if just a name or int
			int idx = 1;
			while (idx < e.length() && e.charAt(idx) != ' ')
				idx++;
			return idx;
		}
	}

	private int getLetSplit(String e) { // to separate parameters from final expression
		if (e.charAt(e.length() - 1) == ')') {
			int count = -1;
			int idx = e.length() - 2;
			while (count != 0) {
				if (e.charAt(idx) == '(')
					count++;
				else if (e.charAt(idx) == ')')
					count--;
				idx--;
			}
			return idx;
		} else {
			int idx = e.length() - 1;
			while (idx >= 0 && e.charAt(idx) != ' ')
				idx--;
			return idx;
		}
	}

	// we need to create new map to represend a scope
	private Map<String, Integer> parsescopes(Map<String, Integer> scopes, String vals) {
		Map<String, Integer> newscopes = new HashMap<>();
		for (Map.Entry<String, Integer> e : scopes.entrySet()) {
			newscopes.put(e.getKey(), e.getValue());
		}
		split(vals, newscopes); // splits parameters and calculates them

		return newscopes;
	}

	// splits parameters and calculates them
	private void split(String e, Map<String, Integer> scopes) {
		int start = 0;
		String key = null;
		for (int end = 0; end <= e.length(); end++) {
			if (end != e.length() && e.charAt(start) == '(') {
				int split = getSplit(e.substring(start));
				scopes.put(key, eval(e.substring(start, start + split), scopes));
				key = null;
				end = start + split;
				start = start + split + 1;
			} else if (end == e.length() || e.charAt(end) == ' ') {
				if (key == null) {
					key = e.substring(start, end);
				} else {
					scopes.put(key, eval(e.substring(start, end), scopes));
					key = null;
				}
				start = end + 1;
			}
		}
	}

	private Integer getVal(Map<String, Integer> scopes, String name) {
		try {
			return Integer.parseInt(name);
		} catch (Exception e) {
			return scopes.get(name);
		}
	}
}
