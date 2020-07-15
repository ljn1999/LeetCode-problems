# 2020.07.14
# this question is so difficult, I tried but I failed, so I looked up the solution

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        # if pattern is empty, string should be empty, else does not match
        # if string is empty, pattern can be non-empty, such as remaining .*
        if not p:
            return not s
        
        # current element match or not
        single_match = False
        
        # if s is not empty
        if s != "":
            if s[0] == p[0] or p[0] == ".":
                single_match = True
        
        if len(p) >= 2 and p[1] == "*":
            # pattern with *
            # can repeat >= 1 time(s) or ignore char* (repeat 0 times)
            # when repeat >= 1 time(s), move string to the next, pattern keeps the same
            # when repeat 0 time, move pattern 2 indexed behind, string keeps the same
            return ((single_match and self.isMatch(s[1:], p)) or self.isMatch(s, p[2: ]))
        else:
            # pass, move forward and check next
            return single_match and self.isMatch(s[1:], p[1:])
        
        
        