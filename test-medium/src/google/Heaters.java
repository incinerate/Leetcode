package google;

import java.util.Arrays;

public class Heaters {

	/*
	 * The idea is to leverage decent Arrays.binarySearch() function provided by
	 * Java.
	 * 
	 * 思路：对于每个house，我们在heater里面找到house左右两边的heater，并取最近的distance。最后在所有house的distance
	 * 中取得最大的distance，这个值就是heater覆盖全house的最小半径。
	 */
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
            	index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }

}
