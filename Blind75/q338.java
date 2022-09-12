// 2022.09.11
// Problem Statement:
// https://leetcode.com/problems/counting-bits/

// idea: base case: 0 and 1
// otherwise, use 1+answer[i-largest 2's power <= i]
class Solution {
    public int[] countBits(int n) {
        int [] answer = new int [n+1];
        for (int i=0; i<=n; i++) {
            if (i==0) answer[0] = 0;
            else if (i==1) answer[1] = 1;
            else {
                int log = (int) (Math.log(i)/Math.log(2));
                answer[i] = answer[i-(int)Math.pow(2, log)]+1;
            }
        }
        return answer;
    }
}