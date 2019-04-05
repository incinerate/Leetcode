package google;
/**
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
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
	 * 思路：此题若直接做，如上面的方法，可以得到答案，只是在row和col特别大的时候报Time exceed错误。仔细读题发现几个细节：
	 * 1.每行的开头必然是String，不是-。2.sentence数组大小最大只有100。3.对于每个String，它在该行的产生的结果都是一样的！
	 * 
	 * 由此，我们另辟蹊径，把sentence中的每个String作为开头，存储一下在该行sentence重复了多少次，记录一下下一行的开头String
	 * 应该是什么。有了这些数据，我们最后只需要进行一下简单的Loop，即可得到最后的result.
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
