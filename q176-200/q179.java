// 2022.05.01
// Problem Statement:
// https://leetcode.com/problems/largest-number/

// idea: use quick sort to sort the array, then combine to an entire string
// when comparing numbers, combine 2 numbers in either orders, 
// num1 following by num2 or num2 following by num1
// then do element comparison
class Solution {
    public boolean smaller_than(int num1, int num2) {
        if (num1==num2) {
            return false;
        }
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        String combined_1 = str1 + str2;
        String combined_2 = str2 + str1;
        for (int i=0; i<combined_1.length(); i++) {
            if (Integer.valueOf(combined_1.charAt(i)) < Integer.valueOf(combined_2.charAt(i))) {  
                return true;
            } else if (Integer.valueOf(combined_1.charAt(i)) > Integer.valueOf(combined_2.charAt(i))) {
                return false;
            }
        }
        return false;
    }
    
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low-1;
        for (int j=low; j<high; j++) {
            if (!smaller_than(nums[j], pivot)) {
                i++;
                int temp_1 = nums[i];
                nums[i] = nums[j];
                nums[j] = temp_1;
            }
        }
        int temp_2 = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp_2;
        return (i+1);
    }
    
    public void quickSort(int[] nums, int low, int high) {
        //printArray(nums, nums.length);
        if (low<high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi-1);
            quickSort(nums, pi+1, high);
        }
    }
    
    static void printArray(int[] arr, int size) {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public String largestNumber(int[] nums) {
        //printArray(nums, nums.length);
        quickSort(nums, 0, nums.length-1);
        //printArray(nums, nums.length);
        String answer = "";
        for (int i=0; i<nums.length; i++) {
            answer = answer + Integer.toString(nums[i]);
        }
        if (Integer.valueOf(nums[0]) == 0) {
            return "0";
        }
        return answer;
    }
}