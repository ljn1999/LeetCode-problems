# 2021.04.04
# Problem Statement:
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
# Referred to the solution here:
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808/My-pretty-simple-code-to-solve-it

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1 or nums[0] < nums[-1]: return nums[0]
        
        left = 0
        right = len(nums)-1
        
        while True:
            middle = int(1/2 * (left + right))
            # when it has narrowed down to 2 numbers, get the smaller one
            if left >= right-1:
                return min(nums[middle], nums[middle+1])
            else:
                if nums[middle]>nums[right]:
                    # search the right
                    left = middle
                elif nums[middle]<nums[right]:
                    # search the left
                    right = middle
                else:
                    # very brilliant, as nums[right] cannot be the first index of the min
                    # narrow down the search range by 1
                    right = right-1
        