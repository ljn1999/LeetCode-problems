# 2020.02.15
# Problem Statement:
# https://leetcode.com/problems/longest-consecutive-sequence/
# I was stupid enough to fail to come up with O(n) solution :-(
# https://leetcode.com/problems/longest-consecutive-sequence/discuss/41057/Simple-O(n)-with-Explanation-Just-walk-each-streak
# Really wanna quote this comment under the discussion page above:
# "I really hate you. Every time your solution makes mine look like shit. EVERY TIME."

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numsSet = set(nums)
        answer = 0
        for element in numsSet:
            # if this element is the start or sequence
            if element - 1 not in numsSet:
                next = element + 1
                # check if the next still exists
                while next in numsSet:
                    next = next + 1
                # compare with the current best solution
                answer = max(answer, next-element)
                
        return answer