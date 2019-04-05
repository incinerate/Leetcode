package google;

public class FindTheDuplicateNumber {
	
	/*
	 * 类似于找linkedlist的环，用快慢指针。快的一次跳两个，慢的一个一个跑，当slow==fast的时候，就找到了duplicate的num。
	 * 
	 * 第一次碰撞点Pos到连接点Join的距离=头指针到连接点Join的距离!!!
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
