package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 12, 2018 12:53:30 PM
 */
public class MissingRange {

	/**
	 * 分情况讨论：A[0],A[A.length-1],和normal condition.
	 * 每种情况中在细分为单个值和区间两种小情况。
	 * @param A
	 * @param lower
	 * @param upper
	 * @return
	 */
	public List<String> findMissingRanges(int[] A, int lower, int upper) {
		ArrayList<String> res = new ArrayList<>();
		if(A[0] > lower) {
			StringBuilder sb = new StringBuilder();
			if(A[0] == lower + 1)  sb.append(lower+"");
			else {
				sb.append(lower+"");
				sb.append("->");
				sb.append(A[0]-1);
			}
			res.add(sb.toString());
		}
		for (int i = 1; i < A.length; i++) {
			StringBuilder sb = new StringBuilder();
			if(A[i] == A[i-1] + 2)  {
				res.add((A[i-1]+1)+"");
			}else if (A[i] > A[i-1] + 2) {
				sb.append(A[i-1]+1+"");
				sb.append("->");
				sb.append(A[i]-1);
				res.add(sb.toString());
			}			
		}
		if(A[A.length - 1] < upper) {
			StringBuilder sb = new StringBuilder();
			if(A[A.length - 1] == upper - 1)  sb.append(upper+"");
			else {
				sb.append(A[A.length - 1]+1);
				sb.append("->");
				sb.append(upper+"");
			}
			res.add(sb.toString());
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,4,50,98};
		System.out.println(new MissingRange().findMissingRanges(A, 0, 99));
	}
}
