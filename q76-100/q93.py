# 2021.01.02
# Problem Statement:
# https://leetcode.com/problems/restore-ip-addresses/
# Referred to the first comment (DFS method) here:
# https://leetcode.com/problems/restore-ip-addresses/discuss/30949/My-code-in-Java

class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        # check for early return
        if len(s) < 4 or len(s) > 12: return []
        
        # initialize answer to return
        self.result = []

        # call DFS helper function
        self.restoreIpAddressesHelper(s, '', 0)
        return self.result

    # temp would be the temporary answer, count would track the total number of ints already in temp    
    def restoreIpAddressesHelper(self, s, temp, count):
        # reach the end or already has 4 ints, should return
        if count == 4 or len(s) == 0:
            # has 4 ints and no remaining digits, append to the answer list
            if count == 4 and len(s) == 0:
                self.result.append(temp[1:]) # get rid of the first dot
            return
        
        # set up the upper bound for the loop
        if s[0] == '0': bound = 1
        else: bound = min(3, len(s))
        
        for i in range(1, bound+1):
            # if can be a potential solution
            if int(s[0:i]) <= 255:
                # modify the temp and check for the rest
                self.restoreIpAddressesHelper(s[i:], temp+'.'+str(s[0:i]), count+1)
            
            # else do nothing