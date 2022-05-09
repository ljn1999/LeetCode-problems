// 2022.05.09
// Problem Statement:
// https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map <Integer, Boolean> exist = new HashMap <Integer, Boolean> ();
        for (int i=0; i<nums.length; i++) {
            if (exist.containsKey(nums[i])) return true;
            else {
                exist.put(nums[i], true);
            }
        }
        return false;
    }
}