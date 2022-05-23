// 2022.05.22
// Problem Statement:
// https://leetcode.com/problems/rotate-image/

// idea: from external circle to internal circle
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n/2; i++) {
            int row = i;
            for (int col=row; col<(n-row)-1; col++) {
                // [row][col] -> [col][n-1-row]
                // [col][n-1-row] -> [n-1-row][n-1-col]
                // [n-1-row][n-1-col] -> [n-1-col][row]
                // [n-1-col][row] -> [row][col]
                int temp = matrix[n-1-col][row];
                matrix[n-1-col][row] = matrix[n-1-row][n-1-col];
                matrix[n-1-row][n-1-col] = matrix[col][n-1-row];
                matrix[col][n-1-row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }
}