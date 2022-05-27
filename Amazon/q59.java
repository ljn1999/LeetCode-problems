// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/spiral-matrix-ii/

// idea: taking circles from outside to inside
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] answer = new int [n][n];
        int num = 1;
        for (int i=0; i<(n+1)/2; i++) { // circle count
            if (2*i+1==n) {
                answer[n/2][n/2] = num;
                break;
            }
            // top
            for (int col=i; col<n-i-1; col++) {
                answer[i][col] = num;
                num++;
            }
            // right
            for (int row=i; row<n-i-1; row++) {
                answer[row][n-1-i] = num;
                num++;
            }
            // bottom
            for (int col=n-i-1; col>i; col--) {
                answer[n-1-i][col] = num;
                num++;
            }
            // left
            for (int row=n-i-1; row>i; row--) {
                answer[row][i] = num;
                num++;
            }
        }
        return answer;
    }
}