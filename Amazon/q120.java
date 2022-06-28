// 2022.06.28
// Problem Statement:
// https://leetcode.com/problems/triangle/

// idea: calculate from bottom to up, for each node, the shortest path to
// the bottom level = the current node + the shortest path to the bottom level 
// of min (the node with same idx in one level lower, 
// the node with index+1 in one level lower)
class Solution {
    int [] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        dp = new int [level];
        for (int i=level-1; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                if (i==level-1) {
                    dp[j] = triangle.get(i).get(j);
                } else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}