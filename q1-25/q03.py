# 2020.07.07

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # corner cases: empty string and string with only one char
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        
        # declare current best result and current string-with-no-duplication
        current_longest = ''
        current_longest = s[0]
        
        current_explored = ''
        current_explored = s[0]
        
        start_index = 0
        end_index = 0
        
        # start from the 2nd element in string
        for index in range(1, len(s)):
            # if not duplicate
            if s[index] not in current_explored:
                # include in current_explored
                end_index = index
                current_explored = s[start_index: end_index+1]
            
            # if exists duplication
            else:
                # start new current_explored
                start_index = current_explored.index(s[index]) + start_index + 1
                end_index = index
                current_explored = s[start_index: end_index+1]
            
            # if find longer string than current best result, do update
            if end_index - start_index >= len(current_longest):
                current_longest = current_explored
        
        return len(current_longest)
        
        