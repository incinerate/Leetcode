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
	 * 思路：首先要对题目所给的rules有精确的理解，简单来说就是1份wage，1份quality，而且每个人
	 * 都有满足其最小wage expectation。
	 * 一开始我想对按wage大小对workers进行排序，把最小的K个wage的加起来即可，因为题目中没有对quality的限制。
	 * 但这么想的话根本就是个easy问题。再三考虑之后发现，发钱时并不是按wage数组发的，而是和wage/quality这个
	 * 比值有关。因为根据rule1，每个worker i,j 的quality[i]：quality[j] == wage[i]:wage[j]的，因此
	 * quality[i]：wage[i] == quality[j]:wage[j],也就是说wage/quality 的ratio对于每个worker来说都一样！！
	 * 
	 * 于是我有了思路，通过这个ratio构建worker数组，并从小到大sort，然后我们取前K个worker，他们的ratio必须是ratio最大的那个
	 * worker的，也就是最近取的那个worker，此时的wage总和就是总的quality * 最近取的worker的ratio。
	 * 
	 * 做到这里感觉程序就可以结束了，因为ratio这里是最小的。但是如果我们继续遍历worker，ratio虽然增大但是quality的总和可能
	 * 会减小。所以我们需要遍历所有worker，保证hire window的size始终为K。
	 * 
	 * 问题又来了，如何保证K个worker的quality在遍历时持续remove最大的quality？ PriorityQueue 可以完美解决这个问题，只需要
	 * add进负的worker quality，此时poll出的就是最大的quality。
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
