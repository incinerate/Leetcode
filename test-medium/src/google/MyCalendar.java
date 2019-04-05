package google;

import java.util.LinkedList;
import java.util.List;

/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
 

Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Feb 3, 2019 9:36:29 PM
 */
public class MyCalendar {

	/*
	 * 思路：每次book就跟之前的记录比较，看有没有overlap，没有的话就加入记录，有的话就返回false。
	 */
	List<int[]> booked;

	public MyCalendar() {
		booked = new LinkedList<>();
	}

	public boolean book(int start, int end) {
		for (int[] p : booked) {
			//Overlap的判定条件，一定牢记！！
			if (Math.max(p[0], start) < Math.min(p[1], end))
				return false;
		}
		booked.add(new int[] { start, end });
		return true;
	}
}
