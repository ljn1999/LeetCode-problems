// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/search-a-2d-matrix-ii/

// idea: divide and conquer from the top right corner,
// everytime rule out a row or a column
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // divide and conquer
        if (matrix.length==1) {
            for (int i=0; i<matrix[0].length; i++) {
                if (matrix[0][i]==target) return true;
            }
            return false;
        } else if (matrix[0].length==1) {
            for (int i=0; i<matrix.length; i++) {
                if (matrix[i][0]==target) return true;
            }
            return false;
        }
        
        int start_v = matrix[0].length-1;
        int start_h = 0;
        while (true) {
            if (matrix[start_h][start_v]==target) return true;
            if (matrix[start_h][start_v]<target) { // rule out this row
                start_h++;
            } else { // rule out this column
                start_v--;
            }
            if (start_h>matrix.length-1 || start_v<0) return false;
        }
    }
}