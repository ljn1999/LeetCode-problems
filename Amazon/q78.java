// 2022.05.28
// Problem Statement:
// https://leetcode.com/problems/subsets/

// idea: recursion, include first element or not to all the subsets of nums[1:]
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length==1) {
            List<List<Integer>> ret = new ArrayList<> ();
            List<Integer> l1 = Arrays.asList(nums[0]);
            ret.add(l1);
            ret.add(new ArrayList<Integer> ());
            return ret;
        }
        
        List<List<Integer>> rest = subsets(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> answer = new ArrayList<> ();
        for (List<Integer> l : rest) {
            answer.add(l);
            List<Integer> new_list = new ArrayList<Integer> (l);
            new_list.add(0, new Integer (nums[0]));
            answer.add(new_list);
        }
        return answer;
    }
}