// 2022.05.19 midnight
// Problem Statement:
// https://leetcode.com/problems/merge-intervals/

// idea: sort by first index, then merge 2 intervals at a time
class Solution {
    public int[] mergeTwo(int[] interval1, int[] interval2) {
        if (interval1[1]>=interval2[0]) {
            return new int [] {interval1[0], Math.max(interval1[1], interval2[1])};
        } else { // cannot merge to 1
            return new int [] {-1, -1};
        }
    }
    
    public int[][] merge(int[][] intervals) {
        if (intervals.length==1) return intervals;
        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
        List<int[]> answer_list = new ArrayList<> ();
        int[] interval1=null;
        int[] interval2=null;
        for (int i=0; i<intervals.length; i++) {
            if (i==0) {
                interval1 = intervals[0];
            } else {
                interval2 = intervals[i];
                int[] temp = mergeTwo(interval1, interval2);
                if (temp[0]==-1 && temp[1]==-1) { // cannot merge, add interval1 into result
                    answer_list.add(interval1);
                    interval1 = interval2;
                } else {
                    interval1 = temp;
                }
            }
        }
        answer_list.add(interval1);
        int [][] answer = new int [answer_list.size()][2];
        for (int i=0; i<answer_list.size(); i++) {
            answer[i][0] = answer_list.get(i)[0];
            answer[i][1] = answer_list.get(i)[1];
        }
        return answer;
    }
}