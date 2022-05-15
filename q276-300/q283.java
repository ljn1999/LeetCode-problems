// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/move-zeroes/

// idea: move none-zero element to the front by count_zero
// and set the current position to zero
class Solution {
    public void moveZeroes(int[] nums) {
        int count_zero = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                count_zero++;
            } else {
                if (count_zero!=0) {
                    nums[i-count_zero] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}