package google;

public class ChampagneTower {

	/*
	 * ˼·���������������ķ�ʽ������poured ȫ����һ�㱭�ӣ�res[0].Ȼ�󵽵ڶ���ĵ�һ������res[0]�͵�����һ��res[0]��
	 * ��������champagne��һ�롣res[1]Ҳ�ǣ���Ϊ�²㱭�ӿ������ϲ��������ӵ�Ӱ�죬�����м�Ҫ�����Լ������champagne����
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
