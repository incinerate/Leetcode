/**
 * 
 */
package mergeIntervals2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mergeIntervals2.Interval;

/**
 * @title mergeIntervals2
 * @description Given a set of non-overlapping intervals, insert a new interval
 *              into the intervals (merge if necessary).
 * 
 *              You may assume that the intervals were initially sorted
 *              according to their start times.
 * 
 *              Example 1: Given intervals [1,3],[6,9], insert and merge [2,5]
 *              in as [1,5],[6,9].
 * 
 *              Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and
 *              merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 *              This is because the new interval [4,9] overlaps with
 *              [3,5],[6,7],[8,10].
 * @author Cun Shi
 * @date: 2018年3月10日 下午4:27:55
 */
public class MergeIntervals {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i).end >= intervals.get(i + 1).start) {
				intervals.set(i + 1, new Interval(Math.min(intervals.get(i).start, intervals.get(i + 1).start),
						Math.max(intervals.get(i + 1).end, intervals.get(i).end)));
				intervals.remove(i);
				i--;
			}
		}
		return intervals;
	}
}
