package reconstructQueueByHeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * @author Administrator
 *
 */
public class ReconstructQueue {

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1];
			}
		});
		List<int[]> list = new LinkedList<int[]>();
		for (int[] ppl : people) {
			list.add(ppl[1], ppl);
		}
		return list.toArray(new int[people.length][]);
	}

	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 },
				{ 5, 2 } };
		System.out.println(Arrays.deepToString(reconstructQueue(people)));

	}
}
