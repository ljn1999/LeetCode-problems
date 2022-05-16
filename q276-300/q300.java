// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/longest-increasing-subsequence/

// idea: https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
// keeps a tail table for all the smallest number of the subsequent of different lengths
// a more complicated method but easier to understand: https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
// binary search + keeping many possible solution arrays
class Solution {
    public int lengthOfLIS(int[] nums) {
        // tail table, tail[i] = min tail number of the subsequent of length i+1
        int [] tails = new int [nums.length];
        int size = 0; // max length of the subsequent
        for (int x: nums) {
            int left = 0, right = size;
            while (left!=right) { // binary search for the suitable position of x
                int mid = (left+right)/2;
                if (tails[mid]<x) { // search to the right
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = x; // put the tail inside
            // if x is larger than every current tail, increase size by 1
            if (left==size) {
                size = size + 1;
            }
        }
        return size;
    }
}