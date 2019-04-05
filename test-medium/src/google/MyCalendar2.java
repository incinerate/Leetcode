package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.

Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
Explanation: 
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Jan 23, 2019 9:45:59 PM
 */
public class MyCalendar2 {

	/*
	 * 思路：brute force， 定义一个overlaps的集合取存储所有的overlap区间，凡是booked中和overlaps区间有
	 * 交集的都不通过。其他均通过，主意每次book后 把数据存储到booked或overlap中。
	 */
	
	// Time O(n^2)
	// Space O(n)
	private List<int[]> booked;
	private List<int[]> overlaps;

	public MyCalendar2() {
		booked = new ArrayList<>();
		overlaps = new ArrayList<>();
	}

	public boolean book(int start, int end) {
		for (int[] range : overlaps)
			//overlap判断
			if (Math.max(range[0], start) < Math.min(range[1], end))
				return false;

		for (int[] range : booked) {
			int ss = Math.max(range[0], start);
			int ee = Math.min(range[1], end);
			if (ss < ee)
				overlaps.add(new int[] { ss, ee });
		}

		booked.add(new int[] { start, end });
		return true;
	}
}
