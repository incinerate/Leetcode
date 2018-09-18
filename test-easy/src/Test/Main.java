package Test;

import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int N, n,m,p;
        N = cin.nextInt();
        n = cin.nextInt();
        m = cin.nextInt();
        p = cin.nextInt();
        int[] A = new int[N];  
        int res = 0;
        A[0] = p;
        for (int i = 1; i < A.length; i++) {
			A[i] = (A[i-1]+153)%A[0];
			System.out.println("A"+A[i]);
		}
        for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				res+=A[subtractionGCD(i,j)-1];
				System.out.println(res);
			}
		}
        
        System.out.println(res);
    }
    
    
    public static int getGCD(int m, int n) {
    	  if (n == 0) {
    	    return m;
    	  }
    	  return getGCD(n, m % n);
    }
    
    public static int subtractionGCD(int m,int n){
        while(m != n){
          if (m>n){
            m = m-n;
          }else {
            n = n - m;
          }
        }
        return m;
      }
	
}