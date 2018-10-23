package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 15, 2018 6:19:47 PM
 */
public class QueueReconstructionbyHeight {

	/**
	 * Pick out tallest group of people and sort them in a subarray (S). 
	 * Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
	   For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.

	E.g.
		input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
		subarray after step 1: [[7,0], [7,1]]
		subarray after step 2: [[7,0], [6,1], [7,1]]
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (p1,p2) -> p1[0] == p2[0]? p1[1] - p2[1] : p2[0] - p1[0]);
		List<int[]> l = new ArrayList<int[]>();
		Arrays.stream(people).forEach(p->l.add(p[1],p));
		return l.toArray(new int[people.length][]);
    }
}
