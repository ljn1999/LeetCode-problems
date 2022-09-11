// 2022.09.10
// Problem Statement:
// https://leetcode.com/problems/two-sum/

// idea: use a hashmap to contain desired numbers to form the target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> ht = new HashMap<> (); // key: target-int[i], value: index
        int [] answer = new int [2];
        for (int i=0; i<nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                answer[0] = ht.get(nums[i]);
                answer[1] = i;
                return answer;
            } else {
                ht.put(target-nums[i], i);
            }
        }
        return answer;
    }
}