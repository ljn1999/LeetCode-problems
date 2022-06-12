// 2022.06.12
// Problem Statement:
// https://leetcode.com/problems/permutations/

// idea: recursion, save the first element and insert it into all possible positions
// in the result of the subarray (excluding the first element)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<> ();
        // base case 1
        if (nums.length==0) {
            List<Integer> one_answer = new ArrayList<> ();
            answer.add(one_answer);
            return answer;
        }
        // base case 2
        if (nums.length==1) {
            List<Integer> one_answer = new ArrayList<> ();
            one_answer.add(nums[0]);
            answer.add(one_answer);
            return answer;
        }
        List<List<Integer>> rest = permute(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> l : rest) {
            for (int i=0; i<=l.size(); i++) {
                List<Integer> copy = new ArrayList<> (l);
                copy.add(i, nums[0]);
                answer.add(copy);
            }
        }
        return answer;
    }
}