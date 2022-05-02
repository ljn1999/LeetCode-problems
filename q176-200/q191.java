// 2022.05.02
// Problem Statement:
// https://leetcode.com/problems/word-frequency/

// idea: similar as question 190 but more simpler
// if negative, revert the msb back to 0
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int answer = 0;
        if (n<0) {
            n = n+(int) Math.pow(2, 31)+1;
            answer = 1;
        }
        for (int i=0; i<31; i++) {
            answer = answer + Math.floorMod(n, 2);
            n=n/2;   
        }
        return answer;
    }
}