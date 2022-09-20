// 2022.09.20
// Problem Statement:
// https://leetcode.com/problems/meeting-rooms-ii/

// idea: use priority queue to store all end-time of ongoing meetings,
// when a new meeting comes, remove all finished meetings' end-time from queue
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sort by start time
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        
        // Priority queue: ascending order, stores the end time of all ongoing meetings
        PriorityQueue <Integer> q = new PriorityQueue <> ();
        int answer = 0;
        int curr_max = intervals[0][1];
        for (int i=0; i<intervals.length; i++) {
            curr_max = Math.max(curr_max, intervals[i][1]);
            // if new interval starts after all previous meetings end,
            // no overlap, reset queue to only one element
            if (intervals[i][0]>=curr_max) {
                q = new PriorityQueue<> ();
                q.offer(intervals[i][1]);
                answer = Math.max(q.size(), answer);
            } else { // when new interval comes, remove all finished jobs from queue
                while (!q.isEmpty() && q.peek()<=intervals[i][0]) {
                    // pop end time which is before i's start
                    q.poll();
                }
                q.offer(intervals[i][1]);
                answer = Math.max(q.size(), answer);
            }
        }
        return answer;
    }
}