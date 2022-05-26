// 2022.05.26 midnight
// Problem Statement:
// https://leetcode.com/problems/maximum-subarray/

// idea: move start and end continuously, if the sum of the subarray [start, end] <= 0,
// abandon this subarray and move both start and end to the next,
// otherwise, only move end forward
class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0, end = 0;
        int answer = Integer.MIN_VALUE;
        int curr_sum = 0;
        while (end!=nums.length) {
            curr_sum += nums[end];
            if (curr_sum<=0) {
                answer = Math.max(answer, curr_sum);
                curr_sum = 0;
                start = end+1;
                end++;
            } else {
                end++;
                answer = Math.max(answer, curr_sum);
            }
        }
        return answer;
    }
}