package google;
/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 30, 2018 9:54:00 PM
 */
public class WiggleSort {

	public void wiggleSort(int[] nums) {
		boolean flag = true;
        for (int i = 0; i < nums.length-1; i++) {
			if(flag) {
				if(nums[i] > nums[i+1]) {
					swap(nums, i, i+1);
				}
                flag = !flag;

			}else {
				if(nums[i] < nums[i+1]) {
					swap(nums, i, i+1);
				}
                flag = !flag;
			}
		}
    }

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
