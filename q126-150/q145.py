# 2020.03.21
# Problem Statement:
# https://leetcode.com/problems/binary-tree-postorder-traversal/
# Referred to a brilliant solution (modification of the previous question) here:
# https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45556/Java-simple-and-clean

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root: return []

        # idea is almost the same as the previous question
        # since preorder: middle -> left -> right
        # and postorder: left -> right -> middle
        # just do a reverse (insert at front) and exchange left and right would be fine
        answer = []
        stack = []
        current = root
        
        while current:
            answer.insert(0, current.val)
            if current.left:
                stack.append(current.left)
            
            current = current.right
            if not current:
                if len(stack) == 0:
                    break
                current = stack[-1]
                stack.pop()
            
        return answer