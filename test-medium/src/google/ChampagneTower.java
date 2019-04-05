package google;

public class ChampagneTower {

	/*
	 * 思路：本题可以用推理的方式，假设poured 全进第一层杯子，res[0].然后到第二层的第一个杯子res[0]就等于上一层res[0]中
	 * 流出来的champagne的一半。res[1]也是，因为下层杯子可能受上层两个杯子的影响，所以切记要加上自己本身的champagne量。
	 */
	
	// Time: O(101)
	public double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[101];
        res[0] = poured;
        for(int row=1; row<=query_row; row++)
            for(int i=row; i>=0; i--) {
            	res[i] = Math.max(0.0, (res[i]-1)/2);
            	res[i+1] += res[i];
            }
        return Math.min(res[query_glass], 1.0);
    }
}
