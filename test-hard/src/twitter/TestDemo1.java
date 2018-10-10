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
	 * ��ѧ�е�ͳ�Ʒ���������������A(3,2)��3*2,A(5,3)��5*4*3
	 * @param first ��ʼ����
	 * @param second ����
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
	 * ʵ������ѧ�н׳˵ķ��� factorialA(5)��5!
	 * @param number
	 * @return
	 */
	public static int factorialA(int number)
	{
		return A(number,number);
	}
	
	/**
	 * ʵ������ѧ�е���Ϸ���C(n,r)�� n!/(n-r)!r!
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
