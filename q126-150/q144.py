# 2020.03.21
# Problem Statement:
# https://leetcode.com/problems/binary-tree-preorder-traversal/
# Referred to the solution here:
# https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/45266/Accepted-iterative-solution-in-Java-using-stack.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root: return []

        # idea: use the First in last out property of stack
        answer = []
        stack = []
        current = root
        
        while current:
            # add the current val into answer list
            answer.append(current.val)

            # add into stack
            if current.right:
                stack.append(current.right)    

            # update current to its left
            current = current.left
            if not current:
                if len(stack) == 0:
                    break
                # update current to the last item in the stack
                current = stack[-1]
                # update the stack
                stack.pop()
            
        return answer