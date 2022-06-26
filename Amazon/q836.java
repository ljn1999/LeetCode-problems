// 2022.06.26
// Problem Statement:
// https://leetcode.com/problems/rectangle-overlap/

// idea: check if one's right bound <= another's left bound
// or if one's up bound <= another's low bound
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[3]<=rec2[1] || rec2[3]<=rec1[1]) return false;
        if (rec1[2]<=rec2[0] || rec2[2]<=rec1[0]) return false;
        return true;
    }
}