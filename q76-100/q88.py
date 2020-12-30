# 2020.12.30
# Problem Statement:
# https://leetcode.com/problems/merge-sorted-array/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        # nums1_ptr will always points to the position in num2 to be compared with the current to-be-inserted element in nums2
        nums1_ptr = 0
        for i in range(0, n):
            # not yet the insert position, increase nums1_ptr
            while nums2[i] > nums1[nums1_ptr] and nums1_ptr <= m+i-1:
                nums1_ptr = nums1_ptr + 1
            # do the insertion
            nums1.insert(nums1_ptr, nums2[i])
            # delete the last item
            nums1.pop()
        
        return