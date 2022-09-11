// 2022.09.10
// Problem Statement:
// https://leetcode.com/problems/maximum-product-subarray/

// idea: if no 0 in the array, then if number of neg is even, the total product is the answer,
// if number of neg is odd, the total product / product up to the first neg number or
// / product up to the last neg number is the answer;
// if 0 is included, separte to subarrays by each 0 and make it a no-0 problem
// a better idea using swap (treat as the max sum subarray problem, but swap min_p and max_p when nums[i]<0)
// https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length==1) return nums[0];
        
        int answer = -1*Integer.MAX_VALUE;
        int total_product = 1;
        int head_product = 1;
        int tail_product = 1;
        int start = 0;
        int end = 0;
        boolean first_neg = false;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) {
                end = i;
                total_product *= nums[i];
                if (!first_neg) {
                    head_product *= nums[i];
                }
                tail_product *= nums[i];
            } else if (nums[i]<0) {
                end = i;
                total_product *= nums[i];
                if (!first_neg) {
                    first_neg = true;
                    head_product *= nums[i];
                }
                tail_product = nums[i];
            } else {
                answer = Math.max(answer, 0);
                if (start==end) {
                    answer = Math.max(answer, nums[start]);
                } else if (total_product>0) {
                    answer = Math.max(answer, total_product);
                } else {
                    answer = Math.max(answer, total_product/head_product);
                    answer = Math.max(answer, total_product/tail_product);
                }
                total_product = 1;
                head_product = 1;
                tail_product = 1;
                first_neg = false;
                start = i+1;
                end = i+1;
            }
        }
        
        if (nums[nums.length-1]==0) return answer;
        if (start==end) {
            answer = Math.max(answer, nums[start]);
        } else if (total_product>0) {
            answer = Math.max(answer, total_product);
        } else {
            answer = Math.max(answer, total_product/head_product);
            answer = Math.max(answer, total_product/tail_product);
        }
        return answer;
    }
}