// 2022.09.16
// Problem Statement:
// https://leetcode.com/problems/longest-consecutive-sequence/

// idea: dfs with cache
class Solution {
    public HashMap<Integer, Integer> ht;
    public int answer = 0;
    public int dfs(int n) {
        if (!ht.containsKey(n)) return 0;
        if (ht.containsKey(n) && ht.get(n)>0) {
            return ht.get(n);
        }
        
        int res = 1+dfs(n+1);
        ht.put(n, res);
        answer = Math.max(answer, res);
        return res;
    }
    
    public int longestConsecutive(int[] nums) {
        ht = new HashMap<> ();
        for (int i=0; i<nums.length; i++) {
            ht.put(nums[i], 0);
        }
        
        for (int i=0; i<nums.length; i++) {
            int x = dfs(nums[i]);
        }
        return answer;
    }
}