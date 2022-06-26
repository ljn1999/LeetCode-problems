// 2022.06.26
// Problem Statement:
// https://leetcode.com/problems/decode-ways/

// idea: the number of decodings of s = number of decodings of s[1:] + number of decodings of s[2:]
// under the case of no leading zeros exist
class Solution {
    int [] dp;
    public int numDecodingsHelper(String s, int start_idx) {
        if (dp[start_idx]!=-1) return dp[start_idx];
        if (s.length()==start_idx) { // if substring length = 0
            return 1;
        }
        if (s.length()-start_idx==1) { // if substring length = 1
            if (s.charAt(start_idx)=='0') {
                dp[start_idx]=0;
                return 0;
            }
            dp[start_idx]=1;
            return 1;
        }
        // if leading zero
        if (s.charAt(start_idx)=='0') {
            dp[start_idx]=0;
            return 0;
        }
        // if leading 2 can form a valid char
        int take_2 = 0;
        if ((s.charAt(start_idx)-'0')*10+s.charAt(start_idx+1)-'0' <= 26) {
            take_2 = numDecodingsHelper(s, start_idx+2);
        }
        int take_1 = numDecodingsHelper(s, start_idx+1);
        dp[start_idx] = take_1 + take_2;
        return take_1 + take_2;
    }

    public int numDecodings(String s) {
        dp = new int [s.length()+1];
        for (int i=0; i<s.length()+1; i++) {
            dp[i] = -1;
        }
        if (s.charAt(0)=='0') return 0;
        if (s.length()<=1) return s.length();
        return numDecodingsHelper(s, 0);
    }
}