// 2022.05.09
// Problem Statement:
// https://leetcode.com/problems/kth-largest-element-in-an-array/

// idea: selection sort
class Solution {
    public int partition(int[] nums, int left, int right) {
        //System.out.println("left"+left+"right"+right);
        int pivot = nums[right];
        int i = left-1;
        for (int j=left; j<right; j++) {
            if (nums[j]>=pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = pivot;
        nums[right] = temp;
        return i+1;
    }
    
    public int findKthLargestHelper(int[] nums, int p, int r, int k) {
        if (p==r) return nums[p];
        int q = partition(nums, p, r);
        int pivot_order_in_nums = q-p+1;
        if (pivot_order_in_nums==k) return nums[q];
        else if (k<pivot_order_in_nums) { // look to the left
            return findKthLargestHelper(nums, p, q-1, k);
        } else { // look to the right
            return findKthLargestHelper(nums, q+1, r, k-pivot_order_in_nums);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, 0, nums.length-1, k);
    }
}