// 2022.06.16 midnight
// Problem Statement:
// https://leetcode.com/problems/insert-interval/

// idea: find the position to insert the newInterval's start and end,
// then see how the intervals should be merged/updated
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) {
            int[][] answer = new int [1][2];
            answer[0][0] = newInterval[0];
            answer[0][1] = newInterval[1];
            return answer;
        }
        
        List<Integer> start_date = new ArrayList<> ();
        List<Integer> end_date = new ArrayList<> ();
        for (int i=0; i<intervals.length; i++) {
            start_date.add(intervals[i][0]);
            end_date.add(intervals[i][1]);
        }
        
        // [ )
        int left = 0, right = start_date.size();
        while (left<right) {
            int mid = left + (right-left)/2;
            if (start_date.get(mid)==newInterval[0]) {
                left = mid;
                break;
            } else if (start_date.get(mid)>newInterval[0]) {
                right = mid; // mid will NOT be the insertion position
            } else {
                left = mid+1; // mid would be the insertion position
            }
        }
        int new_start = left;
        
        left = 0;
        right = end_date.size();
        while (left<right) {
            int mid = left + (right-left)/2;
            if (end_date.get(mid)==newInterval[1]) {
                left = mid;
                break;
            } else if (end_date.get(mid)>newInterval[1]) {
                right = mid; // mid will NOT be the insertion position
            } else {
                left = mid+1; // mid would be the insertion position
            }
        }
        int new_end = left;

        // new start in the middle of interval, new end in the middle of interval
        if (new_start>0 && end_date.get(new_start-1)>=newInterval[0] && 
            new_end<start_date.size() && start_date.get(new_end)<=newInterval[1]) {
            for (int i=new_start; i<=new_end; i++) {
                start_date.remove(new_start);
                end_date.remove(new_start-1);
            }
            int[][] answer = new int [start_date.size()][2];
            for (int i=0; i<answer.length; i++) {
                answer[i][0] = start_date.get(i);
                answer[i][1] = end_date.get(i);
            }
            return answer;
        }
        
        // new start in the middle of interval, new end not in the middle of interval
        if (new_start>0 && end_date.get(new_start-1)>=newInterval[0] && 
            (new_end>=start_date.size() || start_date.get(new_end)>newInterval[1])) {
            for (int i=new_start; i<new_end; i++) {
                start_date.remove(new_start);
                end_date.remove(new_start);
            }
            end_date.set(new_start-1, newInterval[1]);
            int[][] answer = new int [start_date.size()][2];
            for (int i=0; i<answer.length; i++) {
                answer[i][0] = start_date.get(i);
                answer[i][1] = end_date.get(i);
            }
            return answer;
        }
        
        // new start not in the middle of interval, new end in the middle of interval
        if ((new_start==0 || end_date.get(new_start-1)<newInterval[0]) &&
            new_end<start_date.size() && start_date.get(new_end)<=newInterval[1]) {
            for (int i=new_start; i<new_end; i++) {
                start_date.remove(new_start+1);
                end_date.remove(new_start);
            }
            start_date.set(new_start, newInterval[0]);
            int[][] answer = new int [start_date.size()][2];
            for (int i=0; i<answer.length; i++) {
                answer[i][0] = start_date.get(i);
                answer[i][1] = end_date.get(i);
            }
            return answer;
        }
        
        // new start not in the middle of interval, new end not in the middle of interval
        for (int i=new_start; i<new_end-1; i++) {
            start_date.remove(new_start+1);
            end_date.remove(new_start);
        }
        if (new_start==new_end) {
            start_date.add(new_start, newInterval[0]);
            end_date.add(new_start, newInterval[1]);
        } else {
            start_date.set(new_start, newInterval[0]);
            end_date.set(new_start, newInterval[1]);
        }
        int[][] answer = new int [start_date.size()][2];
        for (int i=0; i<answer.length; i++) {
            answer[i][0] = start_date.get(i);
            answer[i][1] = end_date.get(i);
        }
        return answer;
    }
}