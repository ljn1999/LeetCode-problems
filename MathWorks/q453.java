// 2022.10.08
// Problem Statement:
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

// idea: first should move curr min to curr max, so add max-min steps to every number but max,
// then min and max became the new min, then the originally 2nd largest num became the new curr max, 
// move curr min to curr max, until all the numbers are the same.
// equivalent to: make up all the gap from the min to all other numbers, one iteration is enough
class Solution {
    private int min(int[] nums) {
        int min = nums[0];
        for (int i=1; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    public int minMoves(int[] nums) {
        int answer = 0;
        int min_val = min(nums);
        for (int i=0; i<nums.length; i++) {
            answer += (nums[i]-min_val);
        }
        return answer;
    }
}