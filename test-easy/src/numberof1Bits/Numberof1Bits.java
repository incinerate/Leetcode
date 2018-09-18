package numberof1Bits;

public class Numberof1Bits {

	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	
    	int count = 0;
        //注意有负数存在，所以循环条件是n!=0
        while(n!=0) {
        	if((n & 1) == 1) {
        		count++;
        	}
            n>>>=1;
        }
		return count;
    }
}
