package palindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Administrator
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		long con = 0;
		int x0 = x;
		while (x != 0) {
			con = x % 10 + con * 10;
			x = x / 10;
		}
		return con == x0 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(1));
	}
}
