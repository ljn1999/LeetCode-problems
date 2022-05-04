// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/minimum-size-subarray-sum/

// idea: use dp, dp[i] = min(dp[i-1], include the last num into the subarray)
// this one's much smarter
// https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-(two-pointers)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // dp[i] = min(dp[i-1], include the last num into the subarray)
        if (nums.length==1) {
            if (target<=nums[0]) return 1;
            else return 0;
        }
        int [] dp = new int [nums.length];
        if (nums[0]>=target) return 1;
        else dp[0] = Integer.MAX_VALUE;
        for (int i=1; i<nums.length; i++) {
            int sum = 0;
            int if_add = Integer.MAX_VALUE;
            for (int j=i; j>=0; j--) {
                sum = sum + nums[j];
                if (sum>=target) {
                    if_add = i-j+1;
                    break;
                }
            }
            dp[i] = Math.min(dp[i-1], if_add);
            if (dp[i] == 1) return 1; // early return as 1 is the smallest answer
        }
        if (dp[nums.length-1] == Integer.MAX_VALUE) return 0;
        return dp[nums.length-1];
    }
}