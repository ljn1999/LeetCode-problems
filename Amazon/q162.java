// 2022.06.30
// Problem Statement:
// https://leetcode.com/problems/find-peak-element/

// idea: binary search, if < > found, if < < search the right, otherwise search the left
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length==1) return 0;
        if (nums.length==2) {
            if (nums[0]>nums[1]) return 0;
            return 1;
        }
        int left=0, right=nums.length;
        while (left<right) {
            int mid = left + (right-left)/2;
            if (mid==0) {
                return mid;
            } else if (mid==nums.length-1) {
                // return mid or mid-1
                if (nums[mid]<nums[mid-1]) return mid-1;
                return mid;
            } else if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) { // < >
                return mid;
            } else if (nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]) { // < <
                // search the right
                left = mid+1;
            } else { // > < (search either left or right, must have peaks in both parts) or > > (search left)
                // search the left
                right = mid;
            }
        }
        return 0;
    }
}