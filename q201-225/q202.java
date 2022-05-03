// 2022.05.03 midnight
// Problem Statement:
// https://leetcode.com/problems/happy-number/

// idea: iterate over and over until 1 is reached or a duplicate sum appears
class Solution {
    public boolean isHappy(int n) {
        if (n==1) return true;
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>(); // use hashtable for faster search
        int sum = 0;
        while (true) {
            while (n>0) { // calculate the sum
                sum = sum + (int) Math.pow(n%10, 2);
                n = n/10;
            }
            if (sum==1) return true; // 1 is reached
            if (ht.containsKey(sum)) return false; // duplication
            ht.put(sum, 0); // doesn't matter what to put in as value
            n = sum; // update n
            sum = 0; // reset the sum
        }
    }
}