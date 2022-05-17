// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/trapping-rain-water/

// idea: for each position, take zero rain if larger than either left or right max,
// otherwise, take min(left max, right max) - itself rain
class Solution {
    public int trap(int[] height) {
        if (height.length<=2) return 0;
        int [] left_max = new int [height.length];
        int [] right_max = new int [height.length];
        int l_m = 0;
        int r_m = 0;
        left_max[0] = 0; // doesn't matter
        right_max[height.length-1] = 0; // doesn't matter
        for (int i=1; i<height.length; i++) {
            l_m = Math.max(l_m, height[i-1]);
            left_max[i] = l_m;
            r_m = Math.max(r_m, height[height.length-i]);
            right_max[height.length-1-i] = r_m;
        }
        
        int answer = 0;
        for (int i=1; i<height.length-1; i++) {
            if (height[i]<left_max[i] && height[i]<right_max[i]) {
                answer += Math.min(left_max[i], right_max[i])-height[i];
            }
        }
        return answer;
    }
}