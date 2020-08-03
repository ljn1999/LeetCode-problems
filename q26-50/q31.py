# 2020.08.03
# Problem Statement:
# https://leetcode.com/problems/next-permutation/

class Solution:
    # check if the list is already the largest
    def isLargest(nums):
        for i in range(0, len(nums)-1):
            if nums[i] < nums[i+1]:
                return False
        return True
    
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # check empty list
        if len(nums) == 0: return
        
        # check if the list is already the largest
        if Solution.isLargest(nums):
            nums.sort()
            return
        
        # idea:
        # search from right to the left
        # swap the first number which violets the ascending order (from right to left)
        # with the (smallest, but also larger than it) number to its right
        # sort the right part in ascending order

        # initialize the first index to change
        index_to_change_1 = 0
        
        # find the first violation index
        for i in range(0, len(nums)-1):
            if nums[len(nums)-1-i] > nums[len(nums)-1-i-1]:
                index_to_change_1 = len(nums)-1-i-1
                break                
        num_to_change_1 = nums[index_to_change_1]

        # initialize the info of the other number to swap
        num_to_change_2, index_to_change_2 = 0, 0

        # seach for the number (the smallest number with is larger than num_to_change_1)
        diff = inf
        for number in nums[index_to_change_1+1: len(nums)]:
            if number > num_to_change_1 and number-num_to_change_1 < diff:
                diff = number-num_to_change_1
                num_to_change_2 = number
                index_to_change_2 = index_to_change_1+1 \
                + nums[index_to_change_1+1: len(nums)].index(number)
        
        # do the swap
        nums[index_to_change_1] = num_to_change_2
        nums[index_to_change_2] = num_to_change_1
        
        # sort the rest
        nums[index_to_change_1+1: len(nums)] = sorted(nums[index_to_change_1+1: len(nums)])

        return
