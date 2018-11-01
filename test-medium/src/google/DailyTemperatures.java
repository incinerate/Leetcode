package google;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given a list of daily temperatures T, resurn a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 28, 2018 6:18:27 PM
 */
public class DailyTemperatures {
	
	/*
	 * 思路：情况1：如果T[i]>T[idx],res[idx]就是i-idx;情况2：如果T[i]<=T[idx],res就是i-idx,idx不变,因为
	 * 还没有得到res[idx]的结果，所以把i存储到stack中，并把top制作指向stack存的最后一个idx,因为此时最小的T一定是最后加入stack的。
	 * 如果找到了i,就从最小的向前遍历，写入所有的正确结果后，再i++。
	 */
	
	public int[] dailyTemperatures(int[] temperatures) {
		//stack存储res的index
	    int[] stack = new int[temperatures.length];
	    int top = -1;
	    int[] res = new int[temperatures.length];
	    for(int i = 0; i < temperatures.length; i++) {
	        while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
	            int idx = stack[top--];
	            res[idx] = i - idx;
	        }
	        stack[++top] = i;
	    }
	    return res;
	}

	public static void main(String[] args) {
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
	}
}
