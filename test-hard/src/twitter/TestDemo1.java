package twitter;

public class TestDemo1 {

	static int krakenCount(int m, int n) {
		if(m<=0||n<=0) return 0;
		if(m==1||n==1) return 1;	
		int x=m-1,y=n-1;
		int min = Math.min(x, y);
		int count = 0;
		for (int i = 0; i <= min; i++) {
			if(i==0) count += C(x+y,x);
			else if(i==min) count += C(x,min)*C(y,min);
			else {
				for (int j = 1; j <= m-i; j++) {
					for (int k = 1; k <= n-i; k++) {
						count+=krakenCount(j, k);
					}
				}
			}
		}		
		return count;
    }
	
	/**
	 * 数学中的统计方法，用于整数，A(3,2)即3*2,A(5,3)即5*4*3
	 * @param first 开始的数
	 * @param second 个数
	 * @return 
	 */
	public static int A(int first , int second)
	{
		int tmp = first;
		int result = first;
		int count = 0;
		while(count < second-1)
		{
			if(second ==1)
			{
				return first;
			}
			else
			{
				count++;
				tmp--;
				System.out.println(result + "*" + tmp);
				result = result * tmp;	
			}
		}
		return result;
	}
	
	/**
	 * 实现了数学中阶乘的方法 factorialA(5)即5!
	 * @param number
	 * @return
	 */
	public static int factorialA(int number)
	{
		return A(number,number);
	}
	
	/**
	 * 实现了数学中的组合方法C(n,r)即 n!/(n-r)!r!
	 * @param first
	 * @param second
	 * @return
	 */
	public static double C(int n, int r)
	{
		return A(n,r)/factorialA(r);
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(C(5,3));
		System.out.println(krakenCount(50, 5));
	}
}
