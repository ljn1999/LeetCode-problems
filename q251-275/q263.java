// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/ugly-number/

// idea: continuously divide by 5 or 3 or 2 and check if the final result is 1
class Solution {
    public boolean isUgly(int n) {
        if (n<=0) return false; // when n is negative, -1 must be a non-prime factor
                                // when n=0, all non-zero numbers can be its factor
        while (n%5==0) {
            n = n/5;
        }
        while (n%3==0) {
            n = n/3;
        }
        while (n%2==0) {
            n = n/2;
        }
        return (n==1);
    }
}