# 2020.03.14
# Problem Statement:
# https://leetcode.com/problems/single-number/
# Though it's an "easy" question, I couldn't think of any answers with no extra memory space.
# The answer with XOR is so brilliant!
# https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # logic: use bit-wise XOR
        # XOR is commutative, a XOR b = b XOR a,
        # a XOR a = 0,
        # therefore, all duplicate numbers will finally be 0,
        # and result = the unique number ^ 0 = the unique number
        result = 0
    
        for i in range(0, len(nums)):
            result = result ^ nums[i]
            
        return result