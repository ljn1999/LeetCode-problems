# 2021.04.16
# Problem Statement:
# https://leetcode.com/problems/binary-search-tree-iterator/
# https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.root = root
        self.ptr = root
        
        # initialize the ptr to a smallest (most left) position
        while self.ptr.left:
            self.ptr = self.ptr.left
        self.ptr.left = TreeNode(-inf)
        self.ptr = self.ptr.left
        

    def next(self) -> int:
        if self.ptr.right:
            # the successor the left most in the right subtree
            self.ptr = self.ptr.right
            while self.ptr.left:
                self.ptr = self.ptr.left
            return self.ptr.val
        else:
            # idea:
            # if the node is left child: return parent
            # if is right child: return parent's parent's parent... until a left child, then return its parent
            temp_ptr = self.root
            succ_ptr = None
            while True:
                if self.ptr.val < temp_ptr.val:
                    succ_ptr = temp_ptr
                    temp_ptr=  temp_ptr.left
                elif self.ptr.val > temp_ptr.val:
                    temp_ptr = temp_ptr.right
                else:
                    self.ptr = succ_ptr
                    return self.ptr.val
        

    def hasNext(self) -> bool:
        # check if the ptr is in the largest (most right) position
        temp_ptr = self.root
        while temp_ptr.right:
            temp_ptr = temp_ptr.right
        if temp_ptr.val == self.ptr.val:
            return False
        else:
            return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()