package google;

public class FindTheDuplicateNumber {
	
	/*
	 * ��������linkedlist�Ļ����ÿ���ָ�롣���һ��������������һ��һ���ܣ���slow==fast��ʱ�򣬾��ҵ���duplicate��num��
	 * 
	 * ��һ����ײ��Pos�����ӵ�Join�ľ���=ͷָ�뵽���ӵ�Join�ľ���!!!
	 */

	//One condition is we cannot modify the array. So the solution is
	public int findDuplicate_NotModify(int[] nums) {
	    int n = nums.length;
	    int slow = n;
	    int fast = n;
	    do{
	        slow = nums[slow-1];
	        fast = nums[nums[fast-1]-1];
	    }while(slow != fast);
	    slow = n;
	    while(slow != fast){
	        slow = nums[slow-1];
	        fast = nums[fast-1];
	    }
	    return slow;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,5,1,1,4,3};
		System.out.println(new FindTheDuplicateNumber().findDuplicate_NotModify(nums));
		
	}
}
