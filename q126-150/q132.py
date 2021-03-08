# 2020.03.07
# Sorry for no updates in a few days. I'm busy with looking for summer opportunities recently.
# Problem Statement:
# https://leetcode.com/problems/palindrome-partitioning-ii/
# Referred to the dp solution here (using the dp structure for palindrome in last question will also work, but it will take more space):
# https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space.

class Solution:
    def minCut(self, s: str) -> int:
        if len(s) == 0 or len(s) == 1: return 0
        
        dp_min_cut = []
        for i in range(0, len(s)):
            dp_min_cut.append(i)
        
        for center in range(1, len(s)):
            # odd palindrome
            start_odd, end_odd = center, center
            while (start_odd>=0 and end_odd<=len(s)-1 and s[start_odd]==s[end_odd]):
                if start_odd == 0: dp_min_cut[end_odd] = 0
                else:
                    dp_min_cut[end_odd] = min(dp_min_cut[end_odd], dp_min_cut[start_odd-1]+1)
                start_odd = start_odd-1
                end_odd = end_odd+1
            
            # even palindrome
            start_even, end_even = center-1, center
            while(start_even>=0 and end_even<=len(s)-1 and s[start_even]==s[end_even]):
                if start_even == 0: dp_min_cut[end_even] = 0
                else:
                    dp_min_cut[end_even] = min(dp_min_cut[end_even], dp_min_cut[start_even-1]+1)
                start_even = start_even-1
                end_even = end_even+1
                    
        
        return dp_min_cut[-1]