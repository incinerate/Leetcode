package google;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {

	public boolean circularArrayLoop(int[] nums) {
        if(nums.length == 0) return false;
        Set<Integer> visited;
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            visited = new HashSet<>();
            visited.add(i);
            idx = i;
            while(true){
                int newIdx = (nums[idx] + idx)%nums.length;
                if(newIdx<0) newIdx = nums.length + newIdx; 
                if(newIdx == idx || nums[idx] * nums[newIdx] < 0) {
                    break;
                } else{
                    idx = newIdx;
                }
                if(visited.contains(idx)) return true;
                visited.add(idx);
            }
            visited.remove(i);
        }
        return false;
    }
	
	public boolean circularArrayLoop_double_pointer(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // slow/fast pointer
            int j = i, k = getIndex(i, nums);
            while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    // check for loop with only one element
                    if (j == getIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }
            // loop not found, set all element along the way to 0, 0 is the marker of visited but 
            // no loop index, set visited no loop pos = 0, used for distinguishment.
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }
    
    public int getIndex(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }
	
	public static void main(String[] args) {
		int[] nums = {-2, 1, -1, -2, -2};
		System.out.println(new CircularArrayLoop().circularArrayLoop(nums));
	}
}
