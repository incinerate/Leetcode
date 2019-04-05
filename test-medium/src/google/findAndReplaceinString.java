package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * To some string S, we will perform some replacement operations that replace
 * groups of letters with new ones (not necessarily the same size).
 * 
 * Each replacement operation has 3 parameters: a starting index i, a source
 * word x and a target word y. The rule is that if x starts at position i in the
 * original string S, then we will replace that occurrence of x with y. If not,
 * we do nothing.
 * 
 * For example, if we have S = "abcd" and we have some replacement operation i =
 * 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the
 * original string S, we will replace it with "ffff".
 * 
 * Using another example on S = "abcd", if we have both the replacement
 * operation i = 0, x = "ab", y = "eee", as well as another replacement
 * operation i = 2, x = "ec", y = "ffff", this second operation does nothing
 * because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * 
 * All these operations occur simultaneously. It's guaranteed that there won't
 * be any overlap in replacement: for example, S = "abc", indexes = [0, 1],
 * sources = ["ab","bc"] is not a valid test case.
 * 
 * Example 1:
 * 
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets =
 * ["eee","ffff"] Output: "eeebffff" Explanation: "a" starts at index 0 in S, so
 * it's replaced by "eee". "cd" starts at index 2 in S, so it's replaced by
 * "ffff". Example 2:
 * 
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets =
 * ["eee","ffff"] Output: "eeecd" Explanation: "ab" starts at index 0 in S, so
 * it's replaced by "eee". "ec" doesn't starts at index 2 in the original S, so
 * we do nothing. Notes:
 * 
 * 0 <= indexes.length = sources.length = targets.length <= 100 0 < indexes[i] <
 * S.length <= 1000 All characters in given inputs are lowercase letters.
 * 
 * 
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Nov 10, 2018 10:00:22 AM
 */
public class findAndReplaceinString {
	
	/*
	 * 思路：首先要意识到replace过程中S不能随便变换，因为一旦S变，index就乱了。所以想要index不乱的前提下变化S只有把index
	 * 从后往前依次变化，因为后面S长度的变化不会影响前面S的index。并且需要source，targets和sort前的indexes数组角标对应。
	 * 由此，clear version定义一个List存储[indexes[i], i]，用来找到对应的source和target。然后将List按indexes
	 * 数组从大到小排序，然后依次替换。
	 * 
	 * Fastest version用hashmap去存储[indexes[i], i]的关系，由于hashmap排序遍历难，所以我们直接从S的末尾搜索，看map
	 * 中是否有需要replace的地方。借用StringBuilder进行replace。
	 */

	//Clear version
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		List<int[]> sorted = new ArrayList<>();
		for (int i = 0; i < indexes.length; i++)
			sorted.add(new int[] { indexes[i], i });
		Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
		for (int[] ind : sorted) {
			int i = ind[0], j = ind[1];
			String s = sources[j], t = targets[j];
			if (S.substring(i, i + s.length()).equals(s))
				S = S.substring(0, i) + t + S.substring(i + s.length());
		}
		return S;
	}
	
	//Fastest Version
	public String findReplaceString1(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes == null || indexes.length == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        sb.append(S);
        for (int i = S.length() - 1; i >= 0; i--) {
            if (map.containsKey(i)) {
                int index = map.get(i);
                if (S.substring(i).startsWith(sources[index])) {
                    sb.replace(i, i + sources[index].length(), targets[index]);
                }
            }
        }
        return sb.toString();
    }
}
