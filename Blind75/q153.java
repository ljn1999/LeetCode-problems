// 2022.09.10
// Problem Statement:
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// idea: binary search, if not the min, compare with the last element in the array,
// if larger, search right half; if smaller, search the left half
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right) {
            if (left==right) return nums[left];
            int middle = left + (right-left)/2;
            if (middle==0 && nums[middle]<=nums[nums.length-1]) return nums[middle];
            else if (middle>0 && nums[middle]<nums[middle-1]) return nums[middle];
            else if (nums[middle]>nums[right]) { // search right half
                left = middle+1;
            } else { // search the left half
                right = middle-1;
            }
        }
        return 0;
    }
}