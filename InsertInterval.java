/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
        LinkedList<Interval> res = new LinkedList<>();
        
        for (Interval i : intervals)
        {
            if (newInterval == null || newInterval.start > i.end)
            {
                res.add(i);
            }
            else if (i.start > newInterval.end)
            {
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            }
            else
            {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        
        if (newInterval != null)
        {
            res.add(newInterval);
        }
        
        return res;
    }
}
