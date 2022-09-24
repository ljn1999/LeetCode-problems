// 2022.09.24
// Problem Statement:
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

// idea: recursive dfs
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
    private int max_sum = -1*Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
        int t = maxPathSumHelper(root);
        return max_sum;
    }
    public int maxPathSumHelper(TreeNode root) {
        // curr node as path root: max(0, left sub) + max(0, right sub) + root.val
        // curr node as partial path: max(max(0, left sub), max(0, right sub)) + root.val
        if (root==null) return 0;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        // curr node as path root
        int middle = Math.max(0, left)+Math.max(0, right)+root.val;
        // update max_sum
        max_sum = Math.max(max_sum, middle);
        // curr node as partial root
        return Math.max(Math.max(0, left), Math.max(0, right))+root.val;
    }
}