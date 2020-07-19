# 2020.07.19
# Problem Statement
# https://leetcode.com/problems/3sum/
# Tried to deal it as a 2-sum problem, but exceed time limit.
# Answer got inspired by a youtube video:
# https://www.youtube.com/watch?v=CW6G30xQCbw

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # check too short list
        if len(nums) < 3:
            return []
        
        # sort the input list
        nums.sort()

        # initialize answer to return
        answer = []

        # fix the smallest element, and try to find the rest 2 elements
        for i in range(0, len(nums)-2):
            
            # duplicate smallest element should not be count twice
            if not (i > 0 and nums[i] == nums[i-1]):
                
                # initialize the index of the rest 2 elements
                target = -nums[i]
                left = i+1
                right = len(nums)-1

                while left < right:
                    # if get answer
                    if nums[left] + nums[right] == target:
                        if nums[left] == nums[right]:
                            # already get into the middle, break
                            answer.append([-target, nums[left], nums[right]])
                            break
                        else:
                            # not yet to the middle
                            answer.append([-target, nums[left], nums[right]])
                            # do not go through duplicate elements
                            while left < right-1 and nums[left] == nums[left+1]:
                                left = left + 1
                            while left < right-1 and nums[right] == nums[right-1]:
                                right = right - 1
                            # continue move to the middle   
                            left = left + 1
                            right = right - 1

                    # move closer to target        
                    elif nums[left] + nums[right] > target:
                        right = right - 1
                    else:
                        left = left + 1

        return answer