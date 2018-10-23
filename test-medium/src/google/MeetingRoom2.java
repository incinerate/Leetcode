package google;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import google.Interval;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 22, 2018 5:58:53 PM
 */
public class MeetingRoom2 {
	
	/**
	 * ˼·�����ȣ����鿪ʼ��Ȼ��Ӧһ�������������Ұ�start��end�ֱ�����������飬 ��������С��������
	 * ���ڵ�һ��Interval��end > start, ����һ��room��ͬʱ����start��end���䡣
	 * ���ڵڶ���Interval�����end > start, ˵����һ��roomû�����꣬������Ҫһ��room for conference������room++��
	 * ͬ�����start > end, ˵����ʱ��һ��room�Ѿ������ˣ�����room���䣬end���¡�
	 * 
	 * @title MeetingRoom2
	 * @description TODO
	 * @author Cun Shi
	 * @date:   Oct 22, 2018 6:23:00 PM
	 */
	public class Solution {
	    public int minMeetingRooms(Interval[] intervals) {
	        int[] starts = new int[intervals.length];
	        int[] ends = new int[intervals.length];
	        for(int i=0; i<intervals.length; i++) {
	            starts[i] = intervals[i].start;
	            ends[i] = intervals[i].end;
	        }
	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        int rooms = 0;
	        int endsItr = 0;
	        for(int i=0; i<starts.length; i++) {
	            if(starts[i]<ends[endsItr])
	                rooms++;
	            else
	                endsItr++;
	        }
	        return rooms;
	    }
	}
}
