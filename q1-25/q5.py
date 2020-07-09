# 2020.07.09

class Solution:
    def longestPalindrome(self, s: str) -> str:

        # discuss corner cases
        if len(s) == 0:
            return ""
        elif len(s) == 1:
            return s
        elif len(s) == 2:
            if s[0] == s[1]:
                return s
            else:
                return s[0]
        
        # declare current best result and current palindromic substring
        current_longest = ''
        current_longest = s[0]
        
        current_explored = ''
        current_explored = s[0]
        
        center_index = 0
        
        # if there exists substrings with repeat chars, eg: "abbbc"
        # need to know the number of repeat chars
        # if even, center should be 2 chars, palindromic substring shoule be even
        # otherwise center should be 1 char, palindtomic substring should be odd
        
        # initialize count for repeating substrings
        count_left = 0
        count_right = 0
        count_continuous = 1
        
        # each element can be the center of the substring
        # first and last excluded, since current_longest is already initialized as a single-element string
        for index in range(1, len(s)-1):
            count_left, count_right, count_continuous = 0, 0, 1
            center_index = index
            
            # if not continuously reapeating
            if s[center_index] != s[center_index-1] and s[center_index] != s[center_index+1]:
                for i in range(0, min(index+1, len(s)-index)) :
                    if s[center_index-i] == s[center_index+i]:
                        current_explored = s[center_index-i: center_index+i+1]
                    else: # not a palindromic string
                        break

            # continuously repeating            
            else:
                for left_index in range(1, index+1) :
                    if s[center_index] == s[center_index-left_index]:
                        count_left = count_left + 1
                    else:
                        break
                for right_index in range(1, len(s)-index):
                    if s[center_index] == s[center_index+right_index]:
                        count_right = count_right + 1
                    else:
                        break
                count_continuous = count_continuous + count_left + count_right

                # even
                if count_continuous % 2 == 0:
                    current_explored = count_continuous * s[center_index]                    
                    for j in range(0, min(index, len(s)-index)):
                        if s[center_index-1-j] == s[center_index+j]:
                            current_explored = s[center_index-1-j: center_index+j+1]
                        else:
                            break
                # odd
                else:
                    for k in range(0, min(index+1, len(s)-index)) :
                        if s[center_index-k] == s[center_index+k]:
                            current_explored = s[center_index-k: center_index+k+1]
                        else:
                            break

            # update if current result is better
            if len(current_explored) >= len(current_longest):
                current_longest = current_explored
                
        return current_longest