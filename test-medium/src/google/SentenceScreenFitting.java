package google;
/**
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 �� rows, cols �� 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output: 
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 6, 2018 7:29:48 PM
 */
public class SentenceScreenFitting {

	//time exceed
	public int wordsTyping1(String[] sentence, int rows, int cols) {
		int num = 0, res = 0;
		for (int i = 0; i < rows; i++) {
			int pos = 0;
			while(sentence[num].length()+pos<=cols) {
				pos += sentence[num].length()+1;
				if(num == sentence.length-1) {
					num = 0;
					res++;
				}else
					num++;
				
			}
		}
		return res;
    }
	/*
	 * ˼·��������ֱ������������ķ��������Եõ��𰸣�ֻ����row��col�ر���ʱ��Time exceed������ϸ���ⷢ�ּ���ϸ�ڣ�
	 * 1.ÿ�еĿ�ͷ��Ȼ��String������-��2.sentence�����С���ֻ��100��3.����ÿ��String�����ڸ��еĲ����Ľ������һ���ģ�
	 * 
	 * �ɴˣ���������辶����sentence�е�ÿ��String��Ϊ��ͷ���洢һ���ڸ���sentence�ظ��˶��ٴΣ���¼һ����һ�еĿ�ͷString
	 * Ӧ����ʲô��������Щ���ݣ��������ֻ��Ҫ����һ�¼򵥵�Loop�����ɵõ�����result.
	 */
	
	//best answer
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int[] nextRowIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for(int i=0;i<sentence.length;i++) {
            int curLen = 0;
            int index = i;
            int time = 0;
            while(curLen + sentence[index].length() <= cols) {
                curLen += sentence[index++].length()+1;
                if(index==sentence.length) {
                	index = 0;
                    time ++;
                }
            }
            nextRowIndex[i] = index;
            times[i] = time;
        }
        int res = 0;
        int index = 0;
        for(int i=0; i<rows; i++) {
            res += times[index];
            index = nextRowIndex[index];
        }
        return res;
	}
	
	
	
	public static void main(String[] args) {
		String[] sentence = {"a","b"};
		System.out.println(new SentenceScreenFitting().wordsTyping(sentence, 20000, 20000));
	}
}
