// 2022.06.28
// Problem Statement:
// https://leetcode.com/problems/integer-replacement/

// idea: https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations
// bit manipulation, basically trying to remove 1s in the binary representation
// if even, move to right by 1
// if odd, check if add 1 results in more 1s than minus 1,
// take add if ties,
// spacial case: n=3, has to decrease
class Solution {
    public int integerReplacement(int n) {
        int answer = 0;
        while (n!=1) {
            answer++;
            if (n%2==0) {
                n = n>>>1; // n=n/2 is too slow
            } else {
                int plus_cnt_ones = Integer.bitCount(n+1);
                int minus_cnt_ones = Integer.bitCount(n-1);
                if (n==3 || plus_cnt_ones>minus_cnt_ones) {
                    n--;
                } else {
                    n++;
                }
            }
        }
        return answer;
    }

    // Memory Limit Exceeded Solution
    /*HashMap<Integer, Integer> dp;
    public int integerReplacementHelper(int n) {
        if (n==1) return 0;
        if (dp.containsKey(n)) return dp.get(n);
        
        // even
        if (n%2==0) {
            int half = integerReplacementHelper(n/2);
            dp.put(n, 1+half);
            return (1+half);
        }
        
        // odd
        int plus1 = integerReplacementHelper(n+1);
        int minus1 = integerReplacementHelper(n-1);
        dp.put(n, 1+Math.min(plus1, minus1));
        return 1+Math.min(plus1, minus1);
    }
    
    public int integerReplacement(int n) {
        dp = new HashMap<> ();
        if (n==1) return 0;
        return integerReplacementHelper(n);
    }*/
}