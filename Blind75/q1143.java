// 2022.09.11
// Problem Statement:
// https://leetcode.com/problems/longest-common-subsequence/

// idea: use 2d array to store longest subsequence for text1[0:i] and text2[0:j]
// dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i]!=text2[j];
// dp[i][j] = dp[i-1][j-1] + 1
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int [text1.length()][text2.length()];
        for (int i=0; i<text1.length(); i++) {
            for (int j=0; j<text2.length(); j++) {
                if (text1.charAt(i)==text2.charAt(j)) {
                    if (i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1+dp[i-1][j-1];
                    }
                } else {
                    // need to check boundaries, if out of bound -> 0
                    if (i>0 && j>0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    } else if (i==0 && j>0) {
                        dp[i][j] = Math.max(0, dp[i][j-1]);
                    } else if (j==0 && i>0) {
                        dp[i][j] = Math.max(dp[i-1][j], 0);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}