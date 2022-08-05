// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

// idea: set start idx and end idx, separated by 0s;
// before reaching zero, update end idx, negative counts, first and last negative element's idx;
// when reaches zero, update longest length,
// if cnt == even, end-start+1 is curr length, if cnt == odd, max(end-first neg, last neg-start) is curr length
class Solution {
    public int getMaxLen(int[] nums) {
        int first_neg = -1, last_neg = -1;
        int start = 0, end = 0;
        int longest_length = 0;
        int neg_cnt = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) end = i;
            else if (nums[i]<0) {
                if (first_neg==-1) {
                    first_neg = i;
                    last_neg = i;
                } else {
                    last_neg = i;
                }
                neg_cnt++;
                end = i;
            } else {
                if (!((start==end)&&(nums[start]==0))) { // avoid 0 0 0 cases, longest_length would be updated to 1
                    if (neg_cnt%2==0) {
                        longest_length = Math.max(longest_length, end-start+1);
                    } else {
                        longest_length = Math.max(longest_length, end-first_neg);
                        longest_length = Math.max(longest_length, last_neg-start);
                    }
                }
                // reset start, end, negative idx and cnt
                start = i+1;
                end = i+1;
                first_neg = -1;
                last_neg = -1;
                neg_cnt = 0;
            }
        }
        // deal with the last sub-array starting from the last 0
        if (nums[nums.length-1]!=0 && !((start==end)&&(nums[start]==0))) { // avoid 5 5 0 0 cases 
            if (neg_cnt%2==0) {
                longest_length = Math.max(longest_length, end-start+1);
            } else {
                longest_length = Math.max(longest_length, end-first_neg);
                longest_length = Math.max(longest_length, last_neg-start);
            }
        }
        return longest_length;
    }
}