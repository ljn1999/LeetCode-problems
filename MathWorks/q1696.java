// 2022.10.15
// Problem Statement:
// https://leetcode.com/problems/jump-game-vi/

// idea: dp + double-ended queue
class Solution {
    public int maxResult(int[] nums, int k) {
        // dp[i] = max over a (dp[i-a] + nums[i]), a in [1, k]
        // use double-ended queue to get max
        Deque<Integer> dq = new ArrayDeque<> (); // contains only index, nums[index] would be decreasing
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                dq.addLast(i);
                continue;
            }
            
            int max_val = nums[dq.peekFirst()];
            nums[i] = max_val+nums[i]; // have to make changes inside nums

            // keeps the decreasing order
            while (!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // remove front if necessary
            if (!dq.isEmpty() && dq.peekFirst()+k <= i) {
                dq.pollFirst();
            }
            // put index i into deque
            dq.addLast(i);
        }
        return nums[nums.length-1];
    }
}