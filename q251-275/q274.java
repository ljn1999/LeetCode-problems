// 2022.05.13
// Problem Statement:
// https://leetcode.com/problems/h-index/

// idea: https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
// bucket sort, length+1 buckets in total, if citation larger than length, put in the last bucket
// then start from the largest bucket to the smallest, and accumulate count, if count >= bucket index, h is found
class Solution {
    public int hIndex(int[] citations) {
        if (citations.length==1) {
            if (citations[0]==0) return 0;
            else return 1;
        }

        // bucket sort, n+1 buckets in total
        int [] buckets = new int [citations.length+1];
        for (int i=0; i<citations.length; i++) {
            if (citations[i]>=citations.length) {
                buckets[citations.length]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        
        int count=0;
        for (int i=citations.length; i>=0; i--) {
            count = count + buckets[i];
            if (count>=i) return i;
        }
        return 0;
    }
}