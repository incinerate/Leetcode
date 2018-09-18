/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @title mergeIntervals
 * @description Given a collection of intervals, merge all overlapping
 *              intervals.
 * 
 *              For example, Given [1,3],[2,6],[8,10],[15,18], return
 *              [1,6],[8,10],[15,18].
 * 
 * 
 * @author Cun Shi
 * @date: 2018年3月10日 下午4:27:55
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
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
