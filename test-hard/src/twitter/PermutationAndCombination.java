package twitter;

public class PermutationAndCombination {

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
		return factorialA(n)/(factorialA(n-r)*factorialA(r));
	}
}
