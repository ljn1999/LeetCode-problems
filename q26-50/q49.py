# 2020.08.18
# Problem Statement:
# https://leetcode.com/problems/group-anagrams/
# didn't think of using a dictionary, so went out of time limit.
# finally got inspired by the discussion section.

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # check empty case
        if len(strs) == 0: return []

        # initialize a dictionary
        # keys: the sorted chars in each string, stored as a tuple
        # values: a list which contains all anagrmas corresponding to its key
        dictionary = {}
        for i in range(0, len(strs)):
            match = tuple(sorted(strs[i])) in dictionary.keys()
            if match:
                dictionary[tuple(sorted(strs[i]))].append(strs[i])
                    
            if not match:
                dictionary[tuple(sorted(strs[i]))] = [strs[i]]
            
        return dictionary.values()