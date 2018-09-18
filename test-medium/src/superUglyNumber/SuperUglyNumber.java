package superUglyNumber;

/**
 * 
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 11, 2018 4:33:04 PM
 */
public class SuperUglyNumber {

	/*
	 * ˼·����һ��ugly numberӦ����2���ڶ���Ӧ����2*2,1*7,1*13,1*19����ȡ��Ӧ��Ϊ4��������4*2,1*7,1*13,1*19
	 * ȡ7�����Է�����Ҫһ��pointer�������洢ÿһ��prime��������Ӧ�����һ��ugly number���±꣬���Ե�һ��pointerΪ
	 * [0,0,0,0],�ڶ�����[1,0,0,0],��������[2,0,0,0],�����־���[2,1,0,0]��
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n+1];
        ugly[0]=1;
        int[] pointer = new int[primes.length];
        for(int i=1;i<n;i++) {
            int min=Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j=0;j<primes.length;j++) {
                if(ugly[pointer[j]]*primes[j]<min) {
                    min=ugly[pointer[j]]*primes[j];
                    minIndex = j;
                }else if(ugly[pointer[j]]*primes[j]==min) {
                    pointer[j]++;
                }
            }
            ugly[i]=min;
            pointer[minIndex]++;
        }
        return ugly[n-1];
    }
	
	public static void main(String[] args) {
		int[] primes = {2,7,11,19};
		System.out.println(new SuperUglyNumber().nthSuperUglyNumber(15, primes ));
	}
}
