// 2022.05.13
// Problem Statement:
// https://leetcode.com/problems/h-index-ii/

// idea: binary search
class Solution {
    public int hIndexHelper(int[] citations, int lower, int upper) {
        int curr = (lower+upper)/2;
        
        // base case
        if (lower==upper-1) {
            // if lower is good
            if (citations[lower]>=citations.length-lower) return citations.length-lower;
            // if upper is good
            if (upper<citations.length && citations[upper]>=citations.length-upper) {
                return citations.length-upper;
            }
            // if the citations are all zero, it would continuously searching the right 
            // and stop near the end, should return 0
            if (citations[lower]==0) return 0;
            // upper is out of range
            return citations.length-lower;
        }
        
        if (citations.length-curr>=citations[curr]) { // search the right
            return hIndexHelper(citations, curr, upper);
        } else { // search the left
            return hIndexHelper(citations, lower, curr);
        }
    }

    public int hIndex(int[] citations) {
        int lower = 0;
        int upper = citations.length;
        
        return hIndexHelper(citations, lower, upper);
    }
}