// 2022.06.01 midnight
// Problem Statement:
// https://leetcode.com/problems/shuffle-an-array/

// idea: build an arraylist for available numbers, for each index, 
// pick a random number from arraylist and remove it for the next idx.
// another idea: for each index starting from 0, select a random index
// after this index, and swap the values in those 2 indices.
class Solution {
    int [] nums_array;
    public Solution(int[] nums) {
        nums_array = Arrays.copyOf(nums, nums.length);
    }
    
    public int[] reset() {
        return nums_array;
    }
    
    public int[] shuffle() {
        int [] answer = new int [nums_array.length];
        List<Integer> available_nums = new ArrayList<Integer> (nums_array.length);
        for (int i : nums_array) {
            available_nums.add(i);
        }
        for (int i=0; i<nums_array.length; i++) {
            int min=0, max=nums_array.length-1-i;
            int random_idx = (int)Math.floor(Math.random()*(max-min+1)+min);
            answer[i] = available_nums.get(random_idx);
            available_nums.remove(random_idx);
        }
        return answer;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */