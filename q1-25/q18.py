# 2020.07.22
# Problem Statement:
# https://leetcode.com/problems/4sum/

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        # sort the input
        nums.sort()
        
        # check if impossible to get answer
        if len(nums) < 4: return []

        # initialize answer
        answer = []

        # fix the first and last element
        for first in range(0, len(nums)-3):
            for last in reversed(range(first+3, len(nums))):
                # must have at least 4 spaces from first to last
                if first>last-3:
                    break
                
                # check if are going through duplicate elements
                if not ((last <= len(nums)-2 and nums[last] == nums[last+1]) \
                or (first >= 1 and nums[first] == nums[first-1])):
                    
                    # initialize indexes of the second and third component of target
                    left = first+1
                    right = last-1

                    while left < right:
                        # if get answer
                        if nums[first] + nums[left] + nums[right] + nums[last] == target:
                            if nums[left] == nums[right]:
                                # already get into the middle, break
                                answer.append([nums[first], nums[left], nums[right], nums[last]])
                                break
                            else:
                                # not yet to the middle
                                answer.append([nums[first], nums[left], nums[right], nums[last]])
                                # do not go through duplicate elements
                                while left < right-1 and nums[left] == nums[left+1]:
                                    left = left + 1
                                while left < right-1 and nums[right] == nums[right-1]:
                                    right = right - 1
                                # continue move to the middle   
                                left = left + 1
                                right = right - 1

                        # move closer to target        
                        elif nums[left] + nums[right] > target - nums[first] - nums[last]:
                            right = right - 1
                        else:
                            left = left + 1

                    left = first+1
                    right = last-1            
                
        return answer