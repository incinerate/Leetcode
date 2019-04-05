package google;

import java.util.TreeMap;

/**
 * In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.  

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

 

Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation: 
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.
 

Note:

1 <= persons.length = times.length <= 5000
0 <= persons[i] <= persons.length
times is a strictly increasing array with all elements in [0, 10^9].
TopVotedCandidate.q is called at most 10000 times per test case.
TopVotedCandidate.q(int t) is always called with t >= times[0].

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Jan 21, 2019 2:00:31 PM
 */
public class OnlineElection {

	// 思路：此解的brilliant之处在于无需把每个times[i]的leader candidate都加入到map中，只需要把
	// leader candidate变化是的time节点加入即可。然后用TreeMap的floorEntry找到前一个变化节点，取出value即可.
	
	
	private TreeMap<Integer, Integer> map = new TreeMap<>(); // time and leading candidate
    public OnlineElection(int[] persons, int[] times) {
        int[] count = new int[persons.length]; // count[i]: count of votes for persons[i].
        for (int i = 0, max = -1; i < times.length; ++i) {
            ++count[persons[i]]; // at times[i], persons[i] got a vote.
            if (max <= count[persons[i]]) { // is persons[i] leading?
                max = count[persons[i]]; // update leading count.
                map.put(times[i], persons[i]); // update leading candidate.
            }
        }
    }
    public int q(int t) {
        return map.floorEntry(t).getValue(); // fetch the corresponding information. 
    }
}
