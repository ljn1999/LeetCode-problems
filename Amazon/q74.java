// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/search-a-2d-matrix/

// idea: binary search for row and column positions
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==1 && matrix[0].length==1) return matrix[0][0]==target;
        // binary search row
        int top=0, bottom=matrix.length;
        int mid=0;
        while (top<bottom-1) {
            mid = (top+bottom)/2;
            if (matrix[mid][0]==target) return true;
            else if (matrix[mid][0]<target) { // search bottom including this line
                top = mid;
            } else { // search top excluding this line
                bottom = mid;
            }
        }
        
        // binary search col
        int left=0, right=matrix[0].length;
        while (left<right) {
            if (right-left==1) return matrix[top][left]==target;
            mid = (left+right)/2;
            if (matrix[top][mid]==target) return true;
            else if (matrix[top][mid]<target) { // search to the right
                left = mid;
            } else {
                right = mid;
            }
        }
        return false;
    }
}