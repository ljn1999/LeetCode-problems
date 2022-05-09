// 2022.05.09
// Problem Statement:
// https://leetcode.com/problems/contains-duplicate-ii/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map <Integer, Integer> num_idx = new HashMap <Integer, Integer> ();
        for (int i=0; i<nums.length; i++) {
            if (num_idx.containsKey(nums[i])) {
                if (i-num_idx.get(nums[i])<=k) {
                    return true;
                }
            }
            num_idx.put(nums[i], i);
        }
        return false;
    }
}