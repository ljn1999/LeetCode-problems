// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/the-kth-factor-of-n/

// idea: O(sqrt(n)) method, first count total number of factors, only from 1 to sqrt(n) is enough,
// if k is in the first half, already found and returned in the loop,
// if k is in the second half, set k to cnt+1-k (the corresponding number in the first half),
// find the corresponding number in the first half and return n/that num,
// if k is out of range, k would be a neg number, return -1
class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        int cnt = 0;
        for (int i=1; i<=sqrt; i++) {
            if (n%i==0) {
                cnt++;
                if (cnt==k) return i;
            }
        }
        cnt *= 2;
        if (sqrt*sqrt==n) cnt--;
        k = cnt+1-k;
        if (k<0) return -1;
        for (int i=1; i<=sqrt; i++) {
            if (n%i==0) {
                k--;
                if (k==0) return n/i;
            }
        }
        return -1;
    }
}