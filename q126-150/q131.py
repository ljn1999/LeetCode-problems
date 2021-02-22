# 2020.02.21
# Sorry for no updates in a few days. My mood is kind of unstable recently.
# Problem Statement:
# https://leetcode.com/problems/palindrome-partitioning/
# Copied the idea from this post:
# https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution

import numpy as np
class Solution:
    def partition(self, s: str) -> List[List[str]]:        
        # use dp to store if each substring is a palindrome
        is_palindrome = np.zeros((len(s), len(s)))
        for end in range(0, len(s)):
            for start in range(0, end+1):
                if s[start] == s[end] and (end-start<=2 or is_palindrome[start+1][end-1]==1):
                    is_palindrome[start][end] = 1
                       
        self.answer = []
        self.partitionHelper(s, is_palindrome, [], 0)

        return self.answer
                                 
    def partitionHelper(self, s, is_palindrome, one_result, position):

        if position == len(s):
            # have to use a deep copy, otherwise it will not work, 
            # I guess it's because one_result will be changed later
            temp = deepcopy(one_result)
            self.answer.append(temp)
            return
        
        else:
            # DFS
            for i in range(position, len(s)):
                if is_palindrome[position][i]:
                    # add the legal substring
                    one_result.append(s[position:i+1])
                    # continue on with s[position:i+1] as an element
                    self.partitionHelper(s, is_palindrome, one_result, i+1)
                    # after finish one_result with the substring,
                    # one_result in this level still has s[position:i+1] as the last element,
                    # therefore it should be poped out to consider other possibilities
                    one_result.pop()
            return
                