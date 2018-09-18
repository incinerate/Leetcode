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
	 * 思路：第一轮ugly number应该是2；第二轮应该在2*2,1*7,1*13,1*19里面取，应该为4；第三轮4*2,1*7,1*13,1*19
	 * 取7，所以发现需要一个pointer数组来存储每一个prime因子所对应的最后一个ugly number的下标，所以第一轮pointer为
	 * [0,0,0,0],第二轮是[1,0,0,0],第三轮是[2,0,0,0],第四轮就是[2,1,0,0]了
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
