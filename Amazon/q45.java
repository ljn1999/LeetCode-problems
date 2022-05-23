// 2022.05.22
// Problem Statement:
// https://leetcode.com/problems/jump-game-ii/

// idea: for each nums[i], propogate till the max index it can possibly reach,
// update the steps structure if smaller
class Solution {
    public int jump(int[] nums) {
        // propogation
        int [] steps = new int [nums.length];
        steps[0] = 0;
        for (int i=1; i<nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<=Math.min(i+nums[i], nums.length-1); j++) {
                steps[j] = Math.min(steps[i]+1, steps[j]);
            }
        }
        return steps[nums.length-1];
    }
}