package google;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @description TODO
 * @author Cun Shi
 * @date: Oct 15, 2018 5:17:32 PM
 */
public class StrobogrammaticNumber {
	
	public boolean isStrobogrammatic(String num) {
		char[] cs = num.toCharArray();
		int len = num.length();
		for (int i = 0; i < (cs.length+1)/2; i++) {
			if(cs[i] == '6' && cs[len-1-i] == '9') {
				continue;
			}
			else if (cs[i] == '9' && cs[len-1-i] == '6') {
				continue;
			}else if ((cs[i] == '0' || cs[i] == '1' || cs[i] == '8')&&cs[len-1-i] == cs[i]) {
				continue;
			}else {
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new StrobogrammaticNumber().isStrobogrammatic("19661"));
	}
}
	
