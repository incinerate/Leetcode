package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkylineProblem {

	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            // Nice trick to put negative height for the left edge
            heights.add(new int[] {b[0], -b[2]});
            heights.add(new int[] {b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> a[0] != b[0] ? 
            a[0] - b[0] : 
            /* Because we use negative heights here we could get the correct sorting order*/ a[1] - b[1]);
        
        // Max heap of heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        // Height of the previous key point
        int prev = 0;
        List<int[]> result = new ArrayList<>();
        for (int[] h : heights) {
            if (h[1] < 0) {
                // Add the building to priority queue
                pq.offer(-h[1]);
            } else {
                // Remove the building from priority queue
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            // Height changes, so add a new key point to the result
            if (prev != cur) {
                result.add(new int[] {h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[][] builds= {
			{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
		};
		List<int[]> list = new SkylineProblem().getSkyline(builds);
		for (int[] i : list) {
			System.out.print("[");
			for (int j : i) {
				System.out.print(j+" ");
			}
			System.out.print("]");
		}
	}
}
