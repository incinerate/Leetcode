package medianofTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author Administrator
 *
 */
public class MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		List l = new ArrayList<Double>();
		int i = 0, j = 0;
		while (i < nums1.length || j < nums2.length) {
			if (i == nums1.length) {
				l.add(nums2[j]);
				j++;
				continue;
			}
			if (j == nums2.length) {
				l.add(nums1[i]);
				i++;
				continue;
			}
			if (nums1[i] < nums2[j]) {
				l.add(nums1[i]);
				i++;
			} else {
				l.add(nums2[j]);
				j++;
			}
		}
		result = l.size() % 2 == 0 ? 0.5 * ((Integer) l.get(l.size() / 2) + (Integer) l
				.get( (l.size() - 1 )/ 2)) : Double.valueOf((l.get((l.size() - 1)/2)).toString()) ;
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		findMedianSortedArrays(nums1,nums2);
	}
}
