package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class HandOfStraights {

	/*
	 * ˼·����treemapȥ�洢ÿ�����ֵĳ��ִ�����Ȼ���ڱ���treemap��������W�����ּ�����������ܲ��ܸպü��ꡣ
	 */
	public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        //calculate the frequency of each item.
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        
        for (int it : c.keySet())
            if (c.get(it) > 0) 
                for (int i = W - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }
	
	
	//Time Limit Exceed
	public boolean isNStraightHand_(int[] hand, int W) {
		if(W == 1) return true;
        Arrays.sort(hand);
        LinkedList<TreeSet<Integer>> l = new LinkedList<>();
        for(int i = 0; i<hand.length; ++i){
        	boolean success = false;
            if(l.isEmpty()) {
            	l.add(new TreeSet<>());
            	l.getFirst().add(hand[i]);
            	success = true;
            	continue;
            }
            for (int j=0; j< l.size(); ++j) {
				if(hand[i] == l.get(j).last() + 1) {
					l.get(j).add(hand[i]);
					success = true;
				}
				if(l.get(j).size() == W) {
            		l.remove(j);
            	}
				if(success) break;
			}
            if(!success) {
            	TreeSet<Integer> temp = new TreeSet<>();
            	temp.add(hand[i]);
            	l.add(temp);
            }
        }
        return l.isEmpty();
    }
	
	public static void main(String[] args) {
		int[] hand = {1,2,2,3,3,4};
		System.out.println(new HandOfStraights().isNStraightHand(hand, 3));
	}
}
