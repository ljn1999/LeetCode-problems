// 2022.10.16 midnight
// Problem Statement:
// https://leetcode.com/problems/degree-of-an-array/

// idea: use 2 hashmaps to record frequency and start position of first occurance,
// treat > and == cases differently
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<> ();
        HashMap<Integer, Integer> start = new HashMap<> ();
        int degree = 0;
        int num = 0;
        int answer = nums.length;
        for (int i=0; i<nums.length; i++) {
            freq.putIfAbsent(nums[i], 0);
            freq.put(nums[i], freq.get(nums[i])+1);
            if (!start.containsKey(nums[i])) {
                start.put(nums[i], i);
            }
            
            if (freq.get(nums[i])>degree) { // get new degree
                degree = freq.get(nums[i]);
                num = nums[i];
                answer = i-start.get(nums[i])+1;
            } else if (freq.get(nums[i])==degree) { // equal degree, choose the one with smaller subarray length
                if (i-start.get(nums[i])+1<answer) {
                    answer = i-start.get(nums[i])+1;
                    num = nums[i];
                }
            }
        }
        return answer;
    }
}