// 2022.05.22
// Problem Statement:
// https://leetcode.com/problems/3sum/

// idea: fix one number and search the rest as a 2-sum problem (-1*fixed number as the target),
// another idea: sort the nums array and when doing 2-sum problem, increase low / decrease high
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<> ();
        Map <List<Integer>, Integer> dup_check = new HashMap<> ();
        for (int i=0; i<nums.length-2; i++) {
            int target = -1*nums[i];
            Map <Integer, Integer> ht = new HashMap<> ();
            for (int j=i+1; j<nums.length; j++) {
                if (!ht.containsKey(nums[j])) {
                    ht.put(target-nums[j], 1);
                } else {
                    List<Integer> curr = new ArrayList<> ();
                    curr.add(Math.max(Math.max(nums[i], nums[j]), -1*nums[i]-1*nums[j]));
                    curr.add(Math.min(Math.min(nums[i], nums[j]), -1*nums[i]-1*nums[j]));

                    // check duplication
                    if (!dup_check.containsKey(curr)) {
                        dup_check.put(new ArrayList<> (curr), 1);
                        curr.add(0-Math.max(Math.max(nums[i], nums[j]), -1*nums[i]-1*nums[j])-                                                  Math.min(Math.min(nums[i], nums[j]), -1*nums[i]-1*nums[j]));
                        answer.add(curr);
                    } 
                }
            }
            ht = new HashMap<> ();
        }
        return answer;
    }
}