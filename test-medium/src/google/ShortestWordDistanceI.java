package google;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = ��coding��, word2 = ��practice��
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 17, 2018 6:06:25 PM
 */
public class ShortestWordDistanceI {

	/*
	 * ˼·���ҵ���һ��word1��word2�����ҵڶ����������ҵڶ�����ҪһЩ������
	 * 1.��һ�������Ѿ��ҵ�(mark != -1)
	 * 2.�����������ҵ�����word1��word2��
	 */
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int mark = -1, res = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (mark != -1 && !words[mark].equals(words[i])) {
                    res = Math.min(i - mark, res);
                }
				mark = i;
			}
		}
		return res;
	}
}
