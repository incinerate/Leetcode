package google;

import java.util.Map;
import java.util.TreeMap;

/**
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


How many car fleets will arrive at the destination?

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.

Note:

0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
All initial positions are different.


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 16, 2018 8:29:15 PM
 */
public class CarFleet {

	
	public int carFleet(int target, int[] position, int[] speed) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int n = position.length;
		for (int i = 0; i < n; ++i) {
			map.put(-position[i], speed[i]);
		}
		int count = 0;
		double r = -1.0;
		/*
		 * for all car this value must > 0, so we can count for the car closeset to
		 * target
		 */
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int d = entry.getKey(); // distance
			int s = entry.getValue(); // speed
			double t = 1.0 * (target + d) / s; // time to target
			if (t > r) { // this car is unable to catch up previous one, form a new group and update the
							// value
				++count;
				r = t;
			}
		}
		return count;
	}
}
