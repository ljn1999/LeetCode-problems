// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/power-of-two/

// only 32 possible value of power of two
// iterate over the 32 possible values
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        for (int i=0; i<=31; i++) {
            if (n==Math.pow(2, i)) return true;
            if (n<Math.pow(2, i)) return false; // n too small, no need to continue
        }
        return false;
    }
}