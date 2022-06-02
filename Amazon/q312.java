// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/burst-balloons/

// idea: dp: https://leetcode.com/problems/burst-balloons/discuss/76229/For-anyone-that-is-still-confused-after-reading-all-kinds-of-explanations...
// consider the cases where all the ballon could be the last balloon to burst
class Solution {
    public int maxCoins(int[] nums) {
        // dp[left][right] = max(dp[left][k-1] + dp[k+1][right] + nums[left-1]*nums[k]*nums[right+1])
        // last balloon to burst: k
        
        int [][] dp = new int [nums.length][nums.length];

        // base case when length==1
        for (int i=0; i<nums.length; i++) {
            int left=1, right=1;
            if (i-1>=0) left = nums[i-1];
            if (i+1<=nums.length-1) right = nums[i+1];
            dp[i][i] = left*nums[i]*right;
        }

        // fill in the structure by increment of interval length
        for (int diff=1; diff<=nums.length-1; diff++) {
            for (int i=0; i<nums.length-diff; i++) {
                for (int k=i; k<=i+diff; k++) {
                    int left = 0, right = 0;
                    if (k-1>=0) left = dp[i][k-1];
                    if (k+1<=nums.length-1) right = dp[k+1][i+diff];
                    int left_num = 1, right_num = 1;
                    if (i-1>=0) left_num = nums[i-1];
                    if (i+diff+1<=nums.length-1) right_num = nums[i+diff+1];
                    dp[i][i+diff] = Math.max(dp[i][i+diff], left+right+left_num*nums[k]*right_num);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}