# 2020.01.09
# So sorry for the delay, question 99 was so difficult that it took me hours to understand how the Morris Traversal works.
# Hopefully I can memorize the Morris Traversal algorithm instead of just being familiar with its name.
# Also I was occupied with something else these days, basically work, family and rest.
# Problem Statement:
# https://leetcode.com/problems/recover-binary-search-tree/
# Referred to the solution here:
# https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer
# prev in my solution would equal to temp in the solution above, my temp would equal to his prev
# The solution above referred to a Chinese blog here, my code is based on the Chinese blog:
# https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # check empty tree
        if not root: return
        
        # initialize pointers
        cur, prev, temp = root, None, None
        first, second = None, None
        
        # in order traverse, with temp tracking the previous value
        # please note that "prev" is not necessarily the previous node of the current node, "temp" is 
        while cur is not None:
            if cur.left is None:
                # place to do some operations, such as print/compare
                ####################################################
                if temp and temp.val > cur.val:                    
                    if first:
                        second = cur
                    else:
                        first = temp
                        second = cur
                # set the temp to cur
                temp = cur
                ####################################################
                cur = cur.right
            else:
                # find predecessor
                prev = cur.left
                while (prev.right is not None and prev.right != cur):
                    prev = prev.right
                
                if prev.right is None:
                    prev.right = cur                    
                    cur = cur.left
                else:
                    prev.right = None                    
                    # place to do some operations, such as print/compare
                    ####################################################
                    if temp and temp.val > cur.val:
                        if first:
                            second = cur
                        else:
                            first = temp
                            second = cur                    
                    temp = cur
                    ####################################################
                    cur = cur.right                    
        
        # swap
        temp_val = first.val
        first.val = second.val
        second.val = temp_val
                    
                    
                    
                    
                    
                    
                    
                