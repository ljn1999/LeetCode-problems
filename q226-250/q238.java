// 2022.05.12 midnight
// Problem Statement:
// https://leetcode.com/problems/product-of-array-except-self/

// idea: found the pattern by writing down several instances
// when a new number is added to the array, the new number's corresponding value
// in the answer becomes the current product of all the existing numbers.
// the existing numbers' corresponding values in the answer multiples the new number as well.
// but we do not do the multiplies now and we wait until all the new numbers are added.
// then from the end to the beginning, the values in the answer will get multipled.
// idx -2: multiples nums[-1]; idx -3: multiples nums[-1] * nums[-2] ...
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] answer = new int [nums.length];
        int curr_product = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                answer[i] = 1;
            } else {
                answer[i] = curr_product;
                curr_product = curr_product * nums[i];
            }
        }
        
        curr_product = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            answer[i] = answer[i] * curr_product;
            curr_product = curr_product * nums[i];
        }
        return answer;
    }
}