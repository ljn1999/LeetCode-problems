// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

// idea: for each element, if inside boundary, update end idx, potential answer and boundary,
// if outside boundary, update boundary, end idx, 
// find new start position of the new subarray including the current element
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int answer = 1;
        int start=0, end=0;
        int l_b=nums[0]-limit, u_b=nums[0]+limit;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]<=u_b && nums[i]>=l_b) {
                end = i;
                answer = Math.max(answer, end-start+1);
                l_b = Math.max(l_b, nums[i]-limit);
                u_b = Math.min(u_b, nums[i]+limit);
            } else {
                // search back for another start position
                l_b = nums[i]-limit;
                u_b = nums[i]+limit;
                int new_start = i;
                while (nums[new_start-1]<=u_b && nums[new_start-1]>=l_b) {
                    new_start--;
                    l_b = Math.max(l_b, nums[new_start]-limit);
                    u_b = Math.min(u_b, nums[new_start]+limit);
                }
                start = new_start;
                end = i;
            }
        }
        return answer;
    }
}