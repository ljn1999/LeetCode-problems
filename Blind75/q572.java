// 2022.09.24
// Problem Statement:
// https://leetcode.com/problems/subtree-of-another-tree/

// idea: each treenode can possibly be the root of the subtree,
// so search each treenode and use helper function to determine if they're the same tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtreeHelper(TreeNode root, TreeNode subRoot) {
        if (root==null && subRoot==null) return true;
        if (root==null && subRoot!=null) return false;
        if (root!=null && subRoot==null) return false;
        
        if (root.val!=subRoot.val) {
            return false;
        } else {
            boolean left = isSubtreeHelper(root.left, subRoot.left);
            boolean right = isSubtreeHelper(root.right, subRoot.right);
            return left && right;
        }
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSubtreeHelper(root, subRoot)) return true;
        if (root!=null && isSubtree(root.left, subRoot)) return true;
        if (root!=null && isSubtree(root.right, subRoot)) return true;
        return false;
        
    }
}