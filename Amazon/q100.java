// 2022.06.29
// Problem Statement:
// https://leetcode.com/problems/same-tree/

// idea: recursive call, is same tree if left subtree and right subtree are the same and root values are the same
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null) return q==null;
        if (q==null) return p==null;
        return (p.val==q.val) && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }
}