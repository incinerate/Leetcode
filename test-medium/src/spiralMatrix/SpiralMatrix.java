/**
 * 
 */
package spiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @title
 * @description Given a matrix of m x n elements (m rows, n columns), return all
 *              elements of the matrix in spiral order.
 * 
 *              For example, Given the following matrix:
 * 
 *              [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 *              [1,2,3,6,9,8,7,4,5].
 * @author Cun Shi
 * @date: 2018年3月4日 下午5:30:53
 */
public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) 
			return res;
        
		int m = matrix.length; 
		int n = matrix[0].length; 
		int totalNumber = m*n;
		int i = 0;
		int j = 0;
		while(res.size()!= totalNumber && m>0 && n>0) {
            if(2*n == matrix[0].length+1 ){
                for (;i<m;i++) {
				    res.add(matrix[i][j]);
			    }
                return res;
            }
            
            if(2*m == matrix.length+1 ){
                for (;j<n;j++) {
				    res.add(matrix[i][j]);
			    }
                return res;
            }
            
			while(i==matrix.length - m && j < n - 1) {
				res.add(matrix[i][j]);
				j++;
			}
			while(i < m-1 &&j==n-1) {
				res.add(matrix[i][j]);
				i++;
			}
			while(i==m-1 && j!=matrix[0].length - n) {
				res.add(matrix[i][j]);
				j--;
			}
			while(i!=matrix.length - m && j==matrix[0].length - n ) {
				res.add(matrix[i][j]);
				i--;
			}
			m--;
			n--;
            i++;
            j++;
            
		}
		return res;
    
	}

}
