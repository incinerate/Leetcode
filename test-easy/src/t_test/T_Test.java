package t_test;

public class T_Test {

	static int u = 10000; // total average

	public static double OneSampleT_Test(double[] nums) {
		// sample average
		int x = ave(nums);
		// sample standard deviation
		double ssd = standardDeviation(nums, x);
		return (x - u) / (ssd / (Math.sqrt(nums.length - 1)));
	}

	public static double PariedSampleT_Test(double[] nums1, double[] nums2) {
		// sample average
		int x1 = ave(nums1);
		int x2 = ave(nums2);
		// sample standard deviation
		
		double[] nums = new double[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			nums[i] = nums1[i] - nums2[i];
		}
		double s = standardDeviation(nums, x1-x2);

		double temp = s/Math.sqrt(nums.length-1);
		return (x1 - x2) / temp;
	}

	public static double standardDeviation(double[] nums, int x) {
		double ssd = 0;
		for (int i = 0; i < nums.length; i++) {
			ssd += (nums[i] - x) * (nums[i] - x);
		}
		ssd = Math.sqrt(ssd / nums.length);
		return ssd;
	}

	public static int ave(double[] nums) {
		int x;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		x = sum / nums.length;
		return x;
	}

	public static void main(String[] args) {
		double[] nums1 = { 11300, 9890, 10400, 9900, 10545, 12334 };
		double[] nums2 = { 11400, 9800, 11345, 9739, 10787, 12555 };
		System.out.println(OneSampleT_Test(nums1));
		System.out.println(PariedSampleT_Test(nums1, nums2));
	}
}
