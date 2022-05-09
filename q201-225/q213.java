// 2022.05.08
// Problem Statement:
// https://leetcode.com/problems/house-robber-ii/

class Solution {
    public int rob(int[] nums) {
        // cannot rob the first and the last at the same time
        // dp[last] = max(include last exclude 1, include 1 exclude last)
        // include last exclude 1 = do dp with nums[1:]
        // include 1 exclude last = do dp with nums[:-1]
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        int [] dp_1 = new int [nums.length-1]; // excluding the first
        int [] dp_2 = new int [nums.length-1]; // excluding the last
        
        dp_1[0] = nums[1];
        dp_2[0] = nums[0];
        dp_1[1] = Math.max(nums[1], nums[2]);
        dp_2[1] = Math.max(nums[0], nums[1]);
        
        for (int i=2; i<nums.length-1; i++) {
            dp_1[i] = Math.max(dp_1[i-1], dp_1[i-2]+nums[i+1]);
            dp_2[i] = Math.max(dp_2[i-1], dp_2[i-2]+nums[i]);
        }
        
        return Math.max(dp_1[nums.length-2], dp_2[nums.length-2]);   
    }
}