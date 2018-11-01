package google;

import java.util.HashMap;

/**
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 31, 2018 6:10:37 PM
 */
public class FindAnagramMappings {
	
	public int[] anagramMappings(int[] A, int[] B) {
		int[] C = new int[A.length];
		for (int i = 0; i < C.length; i++) {
			while(A[i] != B[C[i]]) {
				C[i]++;
			}
		}
        return C;
    }
	
	//Faster one: Hashmap; Because Its O(1)
	public int[] anagramMappings(int[] A, int[] B,  HashMap<Integer,Integer> map) {
		int l = A.length;
	    int[] res = new int[l];
	    for(int i=0;i<l;i++){
	        map.put(B[i],i);
	    }
	    for(int i=0;i<l;i++){
	        res[i] = map.get(A[i]);
	    }        
	    return res;
    }
}
