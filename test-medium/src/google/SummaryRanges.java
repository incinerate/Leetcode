package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 30, 2018 8:59:20 PM
 */
public class SummaryRanges {

	//思路：一共有两种add情况，一种add一个数字，另外一种add一个区间字符串。所以只要处理这两者的判定条件即可。
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList();
		if(nums.length==1){
			list.add(nums[0]+"");
			return list;
		}
	    for(int i=0;i < nums.length; i++){
	    	int num = nums[i];
	    	while(i<nums.length-1 && (nums[i+1]-nums[i])==1){
	    		i++;
	    	}
	    	if(num!=nums[i]){
	    		list.add(num+"->"+nums[i]);
	    	}else{
	    		list.add(num+"");
	    	}
	    }
	    return list;
    }
}
