// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/jump-game/

// idea: expanding the max idx it can reach, 
// if the current index is already out of reach, directly return false,
// otherwise check if the max region includes the last position
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) { // no need to exclude the last
            // when i==nums.length-1 (reaches the last), 
            // just check the if the final max is greater than its index)
            if (i<=max) {
                max = Math.max(max, i+nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}