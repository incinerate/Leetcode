package google;

import java.util.*;

/**
 * This problem is an interactive problem new to the LeetCode platform.
 * 
 * We are given a word list of unique words, each word is 6 letters long, and
 * one word in this list is chosen as secret.
 * 
 * You may call master.guess(word) to guess a word. The guessed word should have
 * type string and must be from the original list with 6 lowercase letters.
 * 
 * This function returns an integer type, representing the number of ematchact
 * matches (value and position) of your guess to the secret word. Also, if your
 * guess is not in the given wordlist, it will return -1 instead.
 * 
 * For each test case, you have 10 guesses to guess the word. At the end of any
 * number of calls, if you have made 10 or less calls to master.guess and at
 * least one of these guesses was the secret, you pass the testcase.
 * 
 * Besides the ematchample test case below, there will be 5 additional test
 * cases, each with 100 words in the word list. The letters of each word in
 * those testcases were chosen independently at random from 'a' to 'z', such
 * that every word in the given word lists is unique.
 * 
 * Ematchample 1: Input: secret = "acckzz", wordlist =
 * ["acckzz","ccbazz","eiowzz","abcczz"]
 * 
 * Ematchplanation:
 * 
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6
 * matches. master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * 
 * We made 5 calls to master.guess and one of them was the secret, so we pass
 * the test case.
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Nov 3, 2018 12:38:45 PM
 */
public class GuessTheWord {

	/*
	 * 思路：这是一道新类型的题，要在10回合内找wordlist中隐藏的那个secret单词。此题没有限制结果，所以10回合后可能找到，也可能
	 * 找不到。首先我们随机在wordlist里面选一个String次来guess，看有多少字符匹配。然后遍历wordlist，把字符匹配个数与String
	 * 相等的字符串全部取出，更新wordlist。此时就可以排除许多错误的string，最后的secret也一定在更新后的wordlist中。当master.
	 * guess 等于6或者满足10个回合后，代码结束。
	 */

	public void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0, match = 0; i < 10 && match < 6; ++i) {
			String guess = wordlist[new Random().nextInt(wordlist.length)];
			match = master.guess(guess);
			List<String> wordlist2 = new ArrayList<>();
			for (String word : wordlist)
				if (match(guess, word) == match)
					wordlist2.add(word);
			wordlist = wordlist2.toArray(new String[wordlist2.size()]);
		}
	}

	private int match(String a, String b) {
		int matches = 0;
		for (int i = 0; i < a.length(); ++i)
			if (a.charAt(i) == b.charAt(i))
				matches++;
		return matches;
	}
}
