package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * 
 * Input: "19:34" Output: "19:39" Explanation: The next closest time choosing
 * from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It is not
 * 19:33, because this occurs 23 hours and 59 minutes later. Example 2:
 * 
 * Input: "23:59" Output: "22:22" Explanation: The next closest time choosing
 * from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is
 * next day's time since it is smaller than the input time numerically.
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 20, 2018 7:41:58 PM
 */
public class NextClosestTime {
	/**
	 * 思路：首先把组成input的4个数字按从小到大存到set当中，然后组合成所有！！(有效)！！的时间字符串, 字符串从最小开始，依次增大。
	 * 比较target和新minute的大小，如果target > minute, 认为此时的时间与target超过了半天（12h),
	 * 取两者差d，获得第一个res. 随着i的增大，程序将产生下一个minute. 这是比较特殊的情况，如：23:58， 其最近为22:22
	 * 
	 * 一般情况下，最初target是小于minute的， 更新diff和i，直到我们找到最小的diff，此时的res即为最近时间，如：21:49
	 * res为22:11
	 */
	int diff = Integer.MAX_VALUE;
    String result = "";
    
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));
        
        if (set.size() == 1) return time;
        
        List<Integer> digits = new ArrayList<>(set);
        int minute = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));

        dfs(digits, "", 0, minute);

        return result;
    }

    private void dfs(List<Integer> digits, String cur, int pos, int target) {
        if (pos == 4) {
            int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
            if (m == target) return;
            int d = m - target > 0 ? m - target : 1440 + m - target;
            if (d < diff) {
                diff = d;
                result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2) continue;
            if (pos == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23) continue;
            if (pos == 2 && digits.get(i) > 5) continue;
            if (pos == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59) continue;
            dfs(digits, cur + digits.get(i), pos + 1, target);
        }
    }
    
    public static void main(String[] args) {
		System.out.println(new NextClosestTime().nextClosestTime("21:49"));
	}
}
