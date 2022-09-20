// 2022.09.20
// Problem Statement:
// https://leetcode.com/problems/meeting-rooms/

// idea: sort by start time, then check if there's any overlap
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        
        if (intervals.length==0) return true;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (right<=intervals[i][0]) {
                left = intervals[i][0];
                right = intervals[i][1];
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}