package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 2, 2018 4:49:45 PM
 */
public class MinimumCostToHireKWorkers {
	
	/*
	 * ˼·������Ҫ����Ŀ������rules�о�ȷ����⣬����˵����1��wage��1��quality������ÿ����
	 * ������������Сwage expectation��
	 * һ��ʼ����԰�wage��С��workers�������򣬰���С��K��wage�ļ��������ɣ���Ϊ��Ŀ��û�ж�quality�����ơ�
	 * ����ô��Ļ��������Ǹ�easy���⡣��������֮���֣���Ǯʱ�����ǰ�wage���鷢�ģ����Ǻ�wage/quality���
	 * ��ֵ�йء���Ϊ����rule1��ÿ��worker i,j ��quality[i]��quality[j] == wage[i]:wage[j]�ģ����
	 * quality[i]��wage[i] == quality[j]:wage[j],Ҳ����˵wage/quality ��ratio����ÿ��worker��˵��һ������
	 * 
	 * ����������˼·��ͨ�����ratio����worker���飬����С����sort��Ȼ������ȡǰK��worker�����ǵ�ratio������ratio�����Ǹ�
	 * worker�ģ�Ҳ�������ȡ���Ǹ�worker����ʱ��wage�ܺ;����ܵ�quality * ���ȡ��worker��ratio��
	 * 
	 * ��������о�����Ϳ��Խ����ˣ���Ϊratio��������С�ġ�����������Ǽ�������worker��ratio��Ȼ������quality���ܺͿ���
	 * ���С������������Ҫ��������worker����֤hire window��sizeʼ��ΪK��
	 * 
	 * ���������ˣ���α�֤K��worker��quality�ڱ���ʱ����remove����quality�� PriorityQueue �����������������⣬ֻ��Ҫ
	 * add������worker quality����ʱpoll���ľ�������quality��
	 * 
	 */

	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; ++i)
            workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> l = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            l.add(-worker[1]);
            if (l.size() > K) qsum += l.poll();
            if (l.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] quality = {10,20,5}, wage = {70,50,30}; 
		int K = 2;
		System.out.println(new MinimumCostToHireKWorkers().mincostToHireWorkers(quality, wage, K));
	}
}
