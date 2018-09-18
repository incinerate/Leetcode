package reverseInteger;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(0));
	}

	public static int reverse(int x) {
		long con = 0;
		while( x != 0){
            con= con*10 + x % 10;
            x= x/10;
        }
		if( con > Integer.MAX_VALUE || con < Integer.MIN_VALUE)
			return 0;
		else
			return (int) con;
	}
}
