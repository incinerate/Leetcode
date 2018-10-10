package trappingRainWater;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * @author Scott Shi
 *
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int a = 0;
		int b = height.length - 1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;
		while (a <= b) {
			leftmax = Math.max(leftmax, height[a]);
			rightmax = Math.max(rightmax, height[b]);
			if (leftmax < rightmax) {
				max += (leftmax - height[a]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
				a++;
			} else {
				max += (rightmax - height[b]);
				b--;
			}
		}
		return max;
	}
}
