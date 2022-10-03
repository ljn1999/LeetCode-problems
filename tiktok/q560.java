// 2022.10.03 midnight
// Problem Statement:
// https://leetcode.com/problems/subarray-sum-equals-k/

// idea: prefix sum but don't need to store the arraylist, store in a hashtable with count instead
// if curr sum - k is in hashtable's keyset, add answer by the count,
// put the curr sum into hashtable or add its cnt at last to avoid k=6, sum=3, 6-3=itself
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> ht = new HashMap<> ();
        int soln = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum==k) soln++;
            if (ht.containsKey(sum-k)) {
                soln += ht.get(sum-k);
            }
            ht.putIfAbsent(sum, 0);
            ht.put(sum, ht.get(sum)+1);
        }
        return soln;
    }
}