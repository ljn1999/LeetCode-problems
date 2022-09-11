// 2022.09.11 midnight
// Problem Statement:
// https://leetcode.com/problems/container-with-most-water/

// idea: 2 pointers, shrink the size, if left line is smaller than right line, 
// left++, try a better line for a smaller width, and vice versa
class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length-1;
        answer = Math.max(answer, Math.min(height[left], height[right])*(right-left));
        while (left < right) {
            if (height[left]<height[right]) left++;
            else right--;
            answer = Math.max(answer, Math.min(height[left], height[right])*(right-left));
        }
        return answer;
    }
}