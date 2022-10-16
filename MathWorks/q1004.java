// 2022.10.16
// Problem Statement:
// https://leetcode.com/problems/max-consecutive-ones-iii/

// idea: sliding window, can not have > k 0s in the window,
// if more than k 0s, move start to first 0 index + 1
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        Queue<Integer> q = new LinkedList<> ();
        int cnt_0 = 0;
        int answer = 0;
        for (; end<nums.length; end++) {
            if (nums[end]==1) {
                answer = Math.max(answer, end-start+1);
                continue;
            } else {
                cnt_0 ++;
                q.add(end);
                if (cnt_0>k) {
                    int first_0 = q.peek();
                    q.poll();
                    cnt_0--;
                    start = first_0+1;
                }
                answer = Math.max(answer, end-start+1);
            }
        }
        return answer;
    }
}