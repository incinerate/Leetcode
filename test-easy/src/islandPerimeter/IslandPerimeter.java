package islandPerimeter;

import java.util.Arrays;

/**
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * @author Administrator
 *
 */
public class IslandPerimeter {

	 public static int islandPerimeter() {
		 int p = 0;
		 int[][] grid = {{0,1,0,0},
		                 {1,1,1,0},
		                 {0,1,0,0},
		                 {1,1,0,0}};
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]==1){
					p+=4;
					if( i<grid.length-1 && grid[i+1][j]==1) p-=2;
					if( j<grid[i].length-1 && grid[i][j+1]==1) p-=2;
				}
			}
		}
		return p;   
	    }
	 
	 public static void main(String[] args) {
		System.out.println(islandPerimeter());
	}
}
