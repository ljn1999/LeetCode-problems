// 2022.05.10
// Problem Statement:
// https://leetcode.com/problems/rectangle-area/https://leetcode.com/problems/rectangle-area/

// idea: consider 3 cases, in case 3, the overlap area's shape is decided by 
// the middle 2 numbers of all the x and all the y
import java.util.Arrays;
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // case 1, no overlap
        if (ax2<=bx1 || bx2<=ax1 || ay2<=by1 || by2<=ay1) {
            return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        }
        
        // case 2, fully overlap
        if ((ax1<=bx1 && bx2<=ax2 && ay1<=by1 && by2<=ay2) || (bx1<=ax1 && ax2<=bx2 && by1<=ay1 && ay2<=by2)) {
            return Math.max((ax2-ax1)*(ay2-ay1), (bx2-bx1)*(by2-by1));
        }
        
        // case 3, partailly overlap
        int sum = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        int [] x_array = {ax1, ax2, bx1, bx2};
        int [] y_array = {ay1, ay2, by1, by2};
        Arrays.sort(x_array);
        Arrays.sort(y_array);
        int overlap = (y_array[2]-y_array[1])*(x_array[2]-x_array[1]);
        return sum-overlap;
    }
}