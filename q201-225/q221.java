// 2022.05.10 midnight
// Problem Statement:
// https://leetcode.com/problems/maximal-square/

// idea: same as q85 (max rectangle) but used a different calculation
// the area = shorter size of rectangle's square

// a better idea: https://leetcode.com/problems/maximal-square/discuss/600149/Python-Thinking-Process-Diagrams-DP-Approach
// dp, store every point's max side length of the largest squre it can be in (as the bottom right corner)
// base case: matrix[i][j] == '0' -> dp[i][j] = 0
// add zero paddings on the left and top
// if matrix[i][j] == '1' -> dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        // increment by row

        // height[i][j] stores number of continuous 1s up from position (i, j)
        // left[i][j] stores the left boundary of the continuous 1s which can certainly
        // make up a rectangle along with matrix[i][j] with height = height[i][j]
        // similarly, right[i][j] stores the right boundary of the continuous 1s which can certainly
        // make up a rectangle along with matrix[i][j] with height = height[i][j]
        
        // check corner cases
        if (matrix.length==0 || matrix[0].length==0) return 0;
        
        // initialize the data structures
        int [][] height = new int [matrix.length][matrix[0].length];
        int [][] left = new int [matrix.length][matrix[0].length];
        int [][] right = new int [matrix.length][matrix[0].length];
               
        int max_area = 0;
        
        // iterate rows and columns
        for (int i=0; i<matrix.length; i++) {
            
            // initialize left and right boundaries
            int left_boundary = 0;
            int right_boundary = matrix[0].length-1;

            for (int j=0; j<matrix[0].length; j++) {
                
                // fill in the values in "height" and "left"
                if (matrix[i][j] == '1') {
                    if (i >= 1) {
                        height[i][j] = height[i-1][j] + 1;
                        left[i][j] = Math.max(left[i-1][j], left_boundary);
                    } else {
                        height[i][j] = 1;
                        left[i][j] = left_boundary;
                    }
                } else {
                    height[i][j] = 0;
                    left_boundary = j + 1;
                }
                
                // fill in the values in "right"
                if (matrix[i][matrix[0].length-1-j] == '1') {
                    if (i>= 1) {
                        right[i][matrix[0].length-1-j] = 
                        Math.min(right[i-1][matrix[0].length-1-j], right_boundary);
                    } else {
                        right[i][matrix[0].length-1-j] = right_boundary;
                    }
                } else {
                    right[i][matrix[0].length-1-j] = matrix[0].length-1;
                    right_boundary = matrix[0].length-1-j - 1;
                }
            }
        }
        
        // calculate the max area
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (height[i][j] <= right[i][j]-left[i][j]+1) {
                    max_area = Math.max(max_area, height[i][j] * height[i][j]);
                } else {
                    max_area = Math.max(max_area, (right[i][j]-left[i][j]+1)*(right[i][j]-left[i][j]+1));
                }
            }
        }
        return max_area;
    }
}