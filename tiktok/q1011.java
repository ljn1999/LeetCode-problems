// 2022.10.03 midnight
// Problem Statement:
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// idea: binary search, max individual weight as lower bound, sum of all weights as upper bound,
// for each potential cap, check days needs, and compare with the required days
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i=0; i<weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        
        int mid=0;
        while (left<=right) {
            mid = left + (right-left)/2;
            int curr = 0;
            int days_need = 1;
            for (int w: weights) {
                if (w+curr>mid) {
                    curr = w;
                    days_need++;
                } else {
                    curr += w;
                    continue;
                }
            }
            if (days_need>days) { // need larger cap
                left = mid+1;
            } else { // can try smaller cap
                right = mid-1;
            }
        }
        return left;
    }

    /* TLE solution using dfs + dp
    private int [][] dp;
    public int shipWithinDaysHelper(int[] weights, int start, int days) {
        if (dp[start][days-1] != 0) return dp[start][days-1];
        if (days==1) {
            int sum = 0;
            for (int i=start; i<weights.length; i++) {
                sum += weights[i];
            }
            dp[start][days-1] = sum;
            return sum;
        }
        int left_cap = 0;
        int min_val = Integer.MAX_VALUE;
        for (int i=start+1; i<=weights.length-days+1; i++) {
            left_cap += weights[i-1];
            int right_cap = shipWithinDaysHelper(weights, i, days-1);
            int curr = Math.max(left_cap, right_cap);
            min_val = Math.min(min_val, curr);
        }
        dp[start][days-1] = min_val;
        return min_val;
    }
    public int shipWithinDays(int[] weights, int days) {
        // x1 = sum of weights[:i]
        // x2 = cap of weights[i:], days-1
        // max(x1, x2)
        dp = new int [weights.length][days];
        return shipWithinDaysHelper(weights, 0, days);
    }
    */
}