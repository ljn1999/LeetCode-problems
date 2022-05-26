// 2022.05.26
// Problem Statement:
// https://leetcode.com/problems/climbing-stairs/

// idea: dp, but use less only constant space!
class Solution {
    public int climbStairs(int n) {
        // dp[n] = dp[n-1]+dp[n-2]
        if (n==1) return 1;
        if (n==2) return 2;
        int first = 1, second = 2;
        int third = 0;
        for (int i=2; i<n; i++) {
            third = first+second;
            first = second;
            second = third;
        }
        return third;
    }
}