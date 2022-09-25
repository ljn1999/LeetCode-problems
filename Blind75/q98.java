// 2022.09.25 midnight
// Problem Statement:
// https://leetcode.com/problems/validate-binary-search-tree/

// idea: if left and right tree are both valid && left max < root < right min
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
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        
        boolean left = isValidBST(root.left);
        if (!left) return false;
        boolean right = isValidBST(root.right);
        if (!right) return false;
        
        if (root.left!=null) {
            TreeNode curr = root.left;
            while (curr.right!=null) {
                curr = curr.right;
            }
            int left_max = curr.val;
            if (left_max>=root.val) return false;
        }
        if (root.right!=null) {
            TreeNode curr = root.right;
            while (curr.left!=null) {
                curr = curr.left;
            }
            int right_min = curr.val;
            if (right_min<=root.val) return false;
        }
        return true;
    }
}