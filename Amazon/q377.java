// 2022.06.28
// Problem Statement:
// https://leetcode.com/problems/combination-sum-iv/

// idea: recursively search (dfs) for answer, each element in nums could be a part of the answer,
// subtract it from the target but don't remove it from nums, as order matters here
// also use dp to track calculated results (key=target, val=count of combination)
class Solution {
    HashMap<Integer, Integer> dp;
    public int combinationSum4Helper(int[] nums, int target) {
        // note the order here! first check zero -> a solution is found
        // if not zero, check if it's possible to get a solution
        if (target==0) return 1;
        if (target<nums[0]) return 0; // target is smaller than the smallest number
        if (dp.containsKey(target)) return dp.get(target);

        int answer = 0;
        for (int i=0; i<nums.length; i++) {
            answer += combinationSum4Helper(nums, target-nums[i]);
        }
        dp.put(target, answer);
        return answer;
    }
    
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new HashMap<> ();
        int answer = 0;
        for (int i=0; i<nums.length; i++) {
            answer += combinationSum4Helper(nums, target-nums[i]);
        }
        return answer;
    }
}