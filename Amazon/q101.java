// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/symmetric-tree/

// idea: recursion, use a helper function to check if 2 subtrees are symmetric,
// left subtree's right subtree should be symmetric to right subtree's left subtree,
// left subtree's left subtree should be symmetric to right subtree's right subtree,
// otherwise not a symmetric tree
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
    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null) return true;
        if (root1==null || root2==null) return false;
        if (root1.val!=root2.val) {
            return false;
        }
        boolean ret = isSymmetricHelper(root1.left, root2.right);
        if (!ret) return false;
        ret = ret && isSymmetricHelper(root1.right, root2.left);
        return ret;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
}