// 2022.09.11
// Problem Statement:
// https://leetcode.com/problems/reverse-bits/

// idea: first check sign and revert the first bit if is negative (to avoid wrong calculation in %),
// then get the last bit in n and push to left in answer,
// if negative, add the last one to answer
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        boolean neg = (n<0);
        if (neg) {
            n = n +(1<<31);
        }
        
        for (int i=0; i<32; i++) {
            answer = answer + ((n%2)<<(31-i));
            n = n>>1;
        }
        
        if (neg) answer++;
        return answer;
    }
}