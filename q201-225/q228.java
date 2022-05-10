// 2022.05.10
// Problem Statement:
// https://leetcode.com/problems/summary-ranges/

// idea: append each range after it finishes
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length==0) return new ArrayList<String> ();
        List<String> answer = new ArrayList<String> ();
        int left = nums[0];
        int right = nums[0];
        if (nums.length==1) {
            String range = Integer.toString(left);
            answer.add(range);
            return answer;
        }
        for (int i=1; i<nums.length; i++) {
            if (nums[i]-nums[i-1]==1) {
                right = nums[i];
            } else {
                String range = "";
                if (right!=left) {
                    range = Integer.toString(left) + "->" + Integer.toString(right);
                } else {
                    range = Integer.toString(left);
                }
                answer.add(range);
                left = nums[i];
                right = nums[i];
            }
        }

        // have to append the last range manually
        String range = "";
        if (right!=left) {
            range = Integer.toString(left) + "->" + Integer.toString(right);
        } else {
            range = Integer.toString(left);
        }
        answer.add(range);
        return answer;
    }
}