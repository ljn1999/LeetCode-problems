// 2022.05.23
// Problem Statement:
// https://leetcode.com/problems/3sum-closest/

// idea: sort and fix one, then move left and right
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int answer = 0;
        for (int i=0; i<nums.length-2; i++) {
            int fixed = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (nums[left]+nums[right]+fixed==target) return target;
                else if (nums[left]+nums[right]+fixed < target) {
                    if (Math.abs(nums[left]+nums[right]+fixed-target) < diff) {
                        diff = Math.abs(nums[left]+nums[right]+fixed-target);
                        answer = nums[left]+nums[right]+fixed;
                    }
                    left++;
                } else {
                    if (Math.abs(nums[left]+nums[right]+fixed-target) < diff) {
                        diff = Math.abs(nums[left]+nums[right]+fixed-target);
                        answer = nums[left]+nums[right]+fixed;
                    }
                    right--;
                }
            }
            
        }
        return answer;
    }
}