// 2022.06.28
// Problem Statement:
// https://leetcode.com/problems/interleaving-string/

// idea: dfs, either s1 or s2 can be the first one in the interleaving,
// try both possibilities and if neither works, store false in the dp structure
class Solution {
    int [][] dp;
    public boolean isInterleaveHelper(String s1, String s2, String s3) {
        // base cases
        if (s1.length()==0) return s2.equals(s3);
        if (s2.length()==0) return s1.equals(s3);
        // check the dp structure (if substring s1 and substring s2 can form substring s3)
        if (dp[dp.length-s1.length()][dp[0].length-s2.length()]==1) return true;
        else if (dp[dp.length-s1.length()][dp[0].length-s2.length()]==2) return false;
        
        // try s1 as the head
        if (s1.charAt(0)==s3.charAt(0)) {
            boolean b1 = isInterleaveHelper(s1.substring(1), s2, s3.substring(1));
            if (b1) {
                dp[dp.length-s1.length()][dp[0].length-s2.length()] = 1;
                return true;
            }
        }

        // try s2 as the head
        if (s2.charAt(0)==s3.charAt(0)) {
            boolean b2 = isInterleaveHelper(s1, s2.substring(1), s3.substring(1));
            if (b2) {
                dp[dp.length-s1.length()][dp[0].length-s2.length()] = 1;
                return true;
            }
        }
        
        // does not work
        dp[dp.length-s1.length()][dp[0].length-s2.length()] = 2;
        return false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int [s1.length()][s2.length()]; // 0 uncalculated, 1 true, 2 false
        if (s1.length()==0) return s2.equals(s3);
        if (s2.length()==0) return s1.equals(s3);
        if (s3.length()!=(s1.length()+s2.length())) return false;
        return isInterleaveHelper(s1, s2, s3);
    }
}