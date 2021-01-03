# 2020.01.03
# Problem Statement:
# https://leetcode.com/problems/unique-binary-search-trees-ii/
# Referred to the solution here:
# https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # recursion, all num i from 1 to n can be the root,
    # 1 to i-1 should be the left subtree, i+1 to n should be the right subtree
    # then connect each potential left subtree, root and potential right subtree
    def generateTreesHelper(self, start, end):
        temp_list = []
        # can not form a subtree, return null
        if start > end: 
            temp_list.append(None)
        else:
            for i in range(start, end+1):
                left_list = self.generateTreesHelper(start, i-1)
                right_list = self.generateTreesHelper(i+1, end)
                # reconnection
                for left_root in left_list:
                    for right_root in right_list:
                        root = TreeNode(i)
                        root.left = left_root
                        root.right = right_root
                        temp_list.append(root)
            
        return temp_list          
        
    def generateTrees(self, n: int) -> List[TreeNode]:
        # check for exmpty case
        if n == 0: return []
        return self.generateTreesHelper(1, n)