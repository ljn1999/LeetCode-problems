# 2020.09.10
# Problem Statement:
# https://leetcode.com/problems/sort-colors/
# recently my mind is quite slow (maybe actually always), looked up the discussion for one-pass solution:
# https://leetcode.com/problems/sort-colors/discuss/681526/Python-O(n)-3-pointers-in-place-approach-explained

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # ptr_0 is the last position + 1 of sorted 0
        # ptr_1 is the last position + 1 of sorted 1, use it as the discovery pointer
        # ptr_2 is the first postion - 1 of sorted 2
        ptr_0, ptr_1, ptr_2 = 0, 0, len(nums)-1
        
        while ptr_1 <= ptr_2:
            if nums[ptr_1] == 0:
                # should swap with ptr_0
                nums[ptr_0], nums[ptr_1] = nums[ptr_1], nums[ptr_0]
                ptr_1 = ptr_1 + 1
                ptr_0 = ptr_0 + 1
            elif nums[ptr_1] == 1:
                # correct in place, move one index forward
                ptr_1 = ptr_1 + 1            
            else:
                # should swap with ptr_2, but the swapped value remains to be checked
                nums[ptr_1], nums[ptr_2] = nums[ptr_2], nums[ptr_1]
                ptr_2 = ptr_2-1