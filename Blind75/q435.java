// 2022.09.20
// Problem Statement:
// https://leetcode.com/problems/non-overlapping-intervals/

// idea: sort then check if overlaps, always pick the one with smaller end time (greedy)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        
        // pick the one with smaller end time
        int left = intervals[0][0];
        int right = intervals[0][1];
        int cnt = 0;
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0]>=right) {
                left = intervals[i][0];
                right = intervals[i][1];
            } else { // has overlap with this
                cnt++;
                if (right<=intervals[i][1]) { // abandon i
                    continue;
                } else { // substitute curr with i
                    right = intervals[i][1];
                    left = intervals[i][0];
                }
            }
        }
        return cnt;
    }
}