package pow;

/**
 * 
 * @title Pow(x,y)
 * @description Example 1:
 * 
 *              Input: 2.00000, 10 Output: 1024.00000
 * 
 *              Example 2:
 * 
 *              Input: 2.10000, 3 Output: 9.26100
 * @author Cun Shi
 * @date: 2018年1月24日 下午4:28:59
 */
public class Pow {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1.;
		double res = myPow(x, n / 2);
		return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
	}
}
