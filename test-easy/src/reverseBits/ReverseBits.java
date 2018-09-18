package reverseBits;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Example:
 * 
 * Input: 43261596 Output: 964176192 Explanation: 43261596 represented in binary
 * as 00000010100101000001111010011100, return 964176192 represented in binary
 * as 00111001011110000010100101000000.
 * 
 * @author Scott Shi
 *
 */
public class ReverseBits {

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1; // CATCH: must do unsigned shift
			if (i < 31) // CATCH: for last digit, don't shift!
				result <<= 1;
		}
		return result;
	}
}
