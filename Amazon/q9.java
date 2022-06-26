// 2022.06.26
// Problem Statement:
// https://leetcode.com/problems/palindrome-number/

// idea: generate the reversed number and compare with the original x
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int x_org = x;
        int reversed = 0;
        while (x>0) {
            reversed = reversed*10 + x%10;
            x = x/10;
        }
        return reversed == x_org;
    }
}