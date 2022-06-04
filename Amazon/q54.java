// 2022.06.03
// Problem Statement:
// https://leetcode.com/problems/spiral-matrix/

// idea: from external circle to internal circle, if the smaller side is odd, 
// need to append an extra line (vertical or horizontal)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<> ();
        int m=matrix.length, n=matrix[0].length;
        for (int i=0; i<(Math.min(m, n)+1)/2; i++) { // circle
            if (answer.size()==m*n) {
                break;
            }
            if (m==n && 2*i+1==n) {
                answer.add(matrix[m/2][n/2]);
                break;
            }
            if (m>n && i==(n+1)/2-1 && n%2!=0) { // vertical line
                for (int x=i; x<m-i; x++) {
                    answer.add(matrix[x][i]);
                }
                break;
            }
            if (m<n && i==(m+1)/2-1 && m%2!=0) { // horizontal line
                for (int y=i; y<n-i; y++) {
                    answer.add(matrix[i][y]);
                }
                break;
            }
            // top
            for (int col=i; col<n-i-1; col++) {
                answer.add(matrix[i][col]);
            }
            // right
            for (int row=i; row<m-i-1; row++) {
                answer.add(matrix[row][n-1-i]);
            }
            // bottom
            for (int col=n-i-1; col>i; col--) {
                answer.add(matrix[m-1-i][col]);
            }
            // left
            for (int row=m-i-1; row>i; row--) {
                answer.add(matrix[row][i]);
            }
        }
        return answer;
    }
}