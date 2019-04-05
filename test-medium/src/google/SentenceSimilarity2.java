package google;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarity2 {

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		Map<String, String> m = new HashMap<String, String>();
		for (String[] p : pairs) {
			String root1 = find(m, p[0]);
			String root2 = find(m, p[1]);
			if (!root1.equals(root2)) {
				m.put(root1, root2);
			}
		}

		for (int i = 0; i < words1.length; i++)
			if (!words1[i].equals(words2[i]) && !find(m, words1[i]).equals(find(m, words2[i])))
				return false;

		return true;
	}

	private String find(Map<String, String> m, String s) {
		// TODO Auto-generated method stub
		if (!m.containsKey(s))
			m.put(s, s);
		return s.equals(m.get(s)) ? s : find(m, m.get(s));
	}
}
