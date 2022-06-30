// 2022.06.30
// Problem Statement:
// https://leetcode.com/problems/set-matrix-zeroes/

// idea: https://leetcode.com/problems/set-matrix-zeroes/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
// if matrix[i][j] is 0, set indicators in [i][0] and [0][j] as 0,
// then check each element again and decide if set them to 0 according to their indicators,
// finally check 2 flags to check row 0 and col 0
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zero_in_row_0=false, zero_in_col_0=false;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    // use [i][0] and [0][j] as indicators
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i==0) zero_in_row_0 = true;
                    if (j==0) zero_in_col_0 = true;
                }
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0) { // check indicators
                    matrix[i][j] = 0;
                }
            }
        }
        if (zero_in_row_0) {
            for (int col=0; col<matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        if (zero_in_col_0) {
            for (int row=0; row<matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}