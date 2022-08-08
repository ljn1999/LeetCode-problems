// 2022.08.08
// Problem Statement:
// https://leetcode.com/problems/binary-search/

// idea: typical binary search
class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length;
        while(left<right) {
            int mid = left + (right-left)/2;
            if (nums[mid]==target) return mid;
            if (left+1==right) return -1; // when range is narrowed to just 1 element -> not found
            if (nums[mid]<target) left = mid+1;
            else right = mid;
        }
        return -1;
    }
}