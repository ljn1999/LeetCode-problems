// 2022.09.11 midnight
// Problem Statement:
// https://leetcode.com/problems/search-in-rotated-sorted-array/

// idea: first find how much it rotates and if the target is in the left part or right part,
// then do normal binary search
class Solution {
    public int search(int[] nums, int target) {
        int rotate_idx = -1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1]<nums[i]) {
                rotate_idx = i+1;
                break;
            }
        }
        
        int left = 0;
        int right = nums.length-1;
        if (rotate_idx!=-1) {
            if (target>=nums[0]) {
                right = rotate_idx-1;
            } else {
                left = rotate_idx;
            }
        }

        while (left<=right) {
            if (left==right) {
                if (nums[left]==target) return left;
                return -1;
            }
            int mid = left + (right-left)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]<target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}