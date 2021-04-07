# 2021.04.06
# Problem Statement:
# https://leetcode.com/problems/find-peak-element/

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # check corner cases to do early return
        if len(nums) == 1: return 0
        if nums[0] > nums[1]: return 0
        if nums[-1] > nums[-2]: return len(nums)-1
        
        # idea of binary search
        left = 0
        right = len(nums)-1
        
        while True:
            middle = int(1/2 * (left + right))
            # if the index is found
            if nums[middle]>nums[middle-1] and nums[middle]>nums[middle+1]:
                return middle
            # if right is larger than middle,
            # as neighbours could not equal, if the difference between right and middle is smaller than the index difference,
            # there would definitely be a peak in the right half
            if 0<(nums[right]-nums[middle])<(right-middle):
                # search the right
                left = middle
            # if middle is larger than left,
            # as neighbours could not equal, if the difference between middle and left is smaller than the index difference,
            # there would definitely be a peak in the left half
            elif 0<(nums[middle]-nums[left])<(middle-left):
                # search the left
                right = middle
            # if right is smaller than middle, or the difference is large enough
            # or middle is smaller than left, or the difference is large enough
            else:
                # peak must appear in the left half
                if nums[middle-1]>nums[middle]:
                    # search the left
                    right = middle
                # peak must appear in the right half
                else:
                    # search the right
                    left = middle
        