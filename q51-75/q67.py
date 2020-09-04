# 2020.09.04
# Problem Statement:
# https://leetcode.com/problems/add-binary/

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        
        # make a to be the longer string
        if len(a) < len(b):
            a, b = b, a
        
        # do early return
        if a == "0": return b
        if b == "0": return a
        
        # initialize answer to return and initialize the carrier
        answer = ""
        carrier = 0
        
        # iterate when b is not gone through
        for i in range(0, len(b)):           
            answer = str((int(a[len(a)-1-i])+int(b[len(b)-1-i])+carrier)%2) + answer
            if int(a[len(a)-1-i]) + int(b[len(b)-1-i]) + carrier >= 2:
                carrier = 1
            else:
                carrier = 0

        # treat b as 0 and finish the rest    
        for i in range(len(b), len(a)):
            answer = str((int(a[len(a)-1-i]) + carrier)%2) + answer
            if int(a[len(a)-1-i]) + carrier >= 2:
                carrier = 1
            else:
                carrier = 0

        # deal with the last carrier        
        if carrier == 1: return "1" + answer
        else: return answer