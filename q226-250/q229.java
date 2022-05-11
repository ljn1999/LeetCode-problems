// 2022.05.10
// Problem Statement:
// https://leetcode.com/problems/majority-element-ii/

// idea: Boyer Moore Majority Vote
// https://leetcode.com/problems/majority-element-ii/discuss/63537/My-understanding-of-Boyer-Moore-Majority-Vote
// don't really understand how it works
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // at most 2 majority elements
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1==0) { // change candidate 1
                candidate1 = nums[i];
                count1++;
            } else if (count2==0) { // change candidate 2
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        int freq1 = 0;
        int freq2 = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == candidate1) freq1++;
            if (nums[i] == candidate2) freq2++;
        }
        
        List<Integer> answer = new ArrayList<Integer> ();
        if (freq1>(nums.length/3)) answer.add(candidate1);
        if (candidate1!=candidate2 && freq2>(nums.length/3)) answer.add(candidate2);
        return answer;
    }
}