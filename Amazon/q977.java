// 2022.08.06
// Problem Statement:
// https://leetcode.com/problems/squares-of-a-sorted-array/

// idea: 2 pointers, move the left or right one and insert the one with larger abs value
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0, right=nums.length-1;
        int [] answer = new int [nums.length];
        int idx=nums.length-1;
        while (left<=right) {
            if (-1*nums[left]>=nums[right]) { // should insert nums[left] square, increase left and decrease idx
                answer[idx]=nums[left]*nums[left];
                left++;
                idx--;
            } else { // should insert nums[right] square, increase right and decrease idx
                answer[idx]=nums[right]*nums[right];
                right--;
                idx--;
            }
        }
        return answer;
    }
}