// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/two-sum-less-than-k/

// idea: sort and use 2 pointers
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length==1) return -1;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int answer = -1;
        int diff = Integer.MAX_VALUE;
        while (left<right) {
            if (nums[left]+nums[right]<k) {
                if (k-nums[left]-nums[right] < diff) {
                    diff = k-nums[left]-nums[right];
                    answer = nums[left]+nums[right];
                }
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}