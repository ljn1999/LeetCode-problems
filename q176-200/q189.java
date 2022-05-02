// 2022.05.01
// Problem Statement:
// https://leetcode.com/problems/rotate-array/

// idea: find a circlic pattern
// other ideas: reverse the entire list, then seperate into left (k) and right (length-k) part
// then reverse the left and right part again

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (k==0) {
            return;
        }

        int count = 0; // to check if first time in the circle
        int count_total = 0; // to check total elements moved
        int idx = 0;
        int start = 0; // start idx of this circle
        int temp1 = nums[k%nums.length];
        boolean flag = true; // flag to avoid infinite loop
        while (count_total!=nums.length) { // stop when all elements are moved
            if (count==0) {
                flag = true; // reset flag as a new circle begins
                temp1 = nums[(idx+k)%nums.length];
                nums[(idx+k)%nums.length] = nums[idx];
                idx = (idx+k)%nums.length;
                count++;
                count_total++;
            } else if (start == idx && flag) {
                start = start+1;
                idx = start;
                flag = false; // set to false to avoid infinite loop
                count = 0; // reset count as a new circle begins
            } else {
                int temp2 = nums[(idx+k)%nums.length];
                nums[(idx+k)%nums.length] = temp1;
                temp1 = temp2;
                idx = (idx+k)%nums.length;
                count++;
                count_total++;
            }
        }
        
    }
}