// 2022.05.28
// Problem Statement:
// https://leetcode.com/problems/next-permutation/

// idea: if last 2 is decreasing, directly swap,
// find the last index that starts increasing till the end, 
// and find the number in the increasing subarray that's slightly larger
// than the previous (of the increasing subarray) number,
// swap the previous number and the found number, 
// reverse the increasing subarray
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length==1) return;
        if (nums[nums.length-1]>nums[nums.length-2]) {
            int temp = nums[nums.length-1];
            nums[nums.length-1] = nums[nums.length-2];
            nums[nums.length-2] = temp;
            return;
        }
        int idx = nums.length-1;
        for (int i=nums.length-1; i>=1; i--) {
            idx = i;
            if (nums[i]>nums[i-1]) { // increasing
                break;
            }
        }
        
        // 0 to idx-1: unknown
        // idx till end: decreasing
        if (idx==1 && nums[0]>=nums[1]) { // decreasing from the beginning
            for (int i=0; i<nums.length/2; i++) {
                int j = nums.length-1-i;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }
        
        // find the number that's slightly larger than nums[idx-1],
        // set nums[idx-1] = that number,
        // put nums[idx-1] to nums[idx:]
        for (int i=nums.length-1; i>=idx; i--) {
            if (nums[i]>nums[idx-1]) {
                int temp = nums[idx-1];
                nums[idx-1] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        
        // then reverse
        for (int i=idx; i<(nums.length+idx)/2; i++) {
            int j = nums.length-1-(i-idx);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return;
    }
}