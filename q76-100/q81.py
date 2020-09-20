# 2020.09.19
# Problem Statement:
# https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
# my own solution was running out of time limit, so looked up the solution in discussion:
# https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28195/Python-easy-to-understand-solution-(with-comments).

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        # check corner cases
        if len(nums) == 0: return False
        if len(nums) == 1: return nums[0]==target

        # initialize left and right boundary of binary search
        left_bound = 0
        right_bound = len(nums)-1
        index = int(1/2 * (left_bound+right_bound))
        
        while left_bound <= right_bound:
            # the target is found
            if nums[index] == target:
                return True
            
            # have to do this because of the duplicated elements
            while left_bound < index and nums[left_bound] == nums[index]:
                left_bound = left_bound + 1
            
            # at least one part (first or second should be in order)
            # if the first half is in order
            if nums[left_bound] <= nums[index]:
                if nums[index] > target and nums[left_bound] <= target:
                    # search to the left
                    right_bound = index - 1
                    index = int(1/2 * (left_bound+right_bound))
                else:
                    # search to the right
                    left_bound = index + 1
                    index = int(1/2 * (left_bound+right_bound))
            
            # if the second half is in order
            else:
                if nums[index] < target and nums[right_bound] >= target:
                    # search to the right
                    left_bound = index + 1
                    index = int(1/2 * (left_bound+right_bound))
                else:
                    # search to the left
                    right_bound = index - 1
                    index = int(1/2 * (left_bound+right_bound))
                    
        return False