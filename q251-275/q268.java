// 2022.05.13 midnight
// Problem Statement:
// https://leetcode.com/problems/missing-number/

// idea: get the sum and subtract all the numbers that appear in the array,
// the number left is the missing number
class Solution {
    public int missingNumber(int[] nums) {
        int answer = nums.length * (nums.length+1) / 2;
        for (int i=0; i<nums.length; i++) {
            answer = answer - nums[i];
        }
        return answer;
    }
}