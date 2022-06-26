// 2022.06.26
// Problem Statement:
// https://leetcode.com/problems/edit-distance/

// idea: https://leetcode.com/problems/edit-distance/discuss/159295/Python-solutions-and-intuition
// deal with each char from left to right, the char should stay if it's the same in word 1 and 2,
// if different, should either insert or delete or replace
// also use dp to avoid duplicated calculations
class Solution {
    int [][] dp;
    int length_1, length_2;
    public int minDistanceHelper(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int start_idx_1=length_1-word1.length(), start_idx_2=length_2-word2.length();
        if (dp[start_idx_1][start_idx_2]!=0) return dp[start_idx_1][start_idx_2];
        
        // base cases
        if (word1.length()==0) {
            dp[start_idx_1][start_idx_2] = word2.length();
            return word2.length(); // all insertion
        }
        if (word2.length()==0) {
            dp[start_idx_1][start_idx_2] = word1.length();
            return word1.length(); // all insertion
        }
        if (word1.charAt(0)==word2.charAt(0)) {
            return minDistanceHelper(word1.substring(1), word2.substring(1));
        }
        int insert = 1+minDistanceHelper(word1, word2.substring(1));
        int delete = 1+minDistanceHelper(word1.substring(1), word2);
        int replace = 1+minDistanceHelper(word1.substring(1), word2.substring(1));
        int min_val = Math.min(insert, Math.min(delete, replace));
        dp[start_idx_1][start_idx_2] = min_val;
        return min_val;
    }
    
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        length_1 = word1.length();
        length_2 = word2.length();
        dp = new int [word1.length()+1][word2.length()+1];
        return minDistanceHelper(word1, word2);
    }
}