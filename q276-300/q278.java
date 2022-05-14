// 2022.05.13
// Problem Statement:
// https://leetcode.com/problems/first-bad-version/

// idea: binary search
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersionHelper(int lower, int upper) {
        int curr = lower+(upper-lower)/2; // cannot use (upper+lower)/2, otherwise has TLE issue
        boolean curr_bad = isBadVersion(curr);
        boolean prev_bad = false;
        if (curr>1) prev_bad = isBadVersion(curr-1);

        if (curr_bad && !prev_bad) return curr; // first bad is found
        if (curr_bad && prev_bad) {
            return firstBadVersionHelper(lower, curr-1);
        } else {
            return firstBadVersionHelper(curr+1, upper);
        }
    }

    public int firstBadVersion(int n) {
        if (n==1) return 1;
        if (isBadVersion(1)) return 1;
        int lower=1, upper=n;
        return firstBadVersionHelper(lower, upper);
    }
}