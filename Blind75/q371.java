// 2022.09.11
// Problem Statement:
// https://leetcode.com/problems/sum-of-two-integers/

// idea: bits manipulation
class Solution {
    public int getSum(int a, int b) {
        int temp1 = a^b;
        int temp2 = (a&b)<<1;
        while (temp2 != 0) {
            int temp3 = temp1;
            temp1 = temp1^temp2; // old temp1 xor temp2
            temp2 = (temp3&temp2)<<1; // old (temp1 & temp2) << 1
        }
        return temp1;
    }
}