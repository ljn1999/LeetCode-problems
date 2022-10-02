// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/cousins-in-binary-tree/

// idea: bfs to find levels, use global parameter to record parents
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
    private int x_parent;
    private int x_level;
    private int y_parent;
    private int y_level;
    
    private int search(TreeNode root, int target, int level, boolean is_x) {
        if (root==null) {
            return -1;
        } else if (root.left!=null && root.left.val==target) {
            if (is_x) x_parent = root.val;
            else y_parent = root.val;
            return level+1;
        } else if (root.right!=null && root.right.val==target) {
            if (is_x) x_parent = root.val;
            else y_parent = root.val;
            return level+1;
        }
        
        int left = search(root.left, target, level+1, is_x);
        if (left!=-1) {
            return left;
        }
        int right = search(root.right, target, level+1, is_x);
        if (right!=-1) {
            return right;
        }
        return -1;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        int l = search(root, x, 0, true);
        int r = search(root, y, 0, false);
        return (l==r && x_parent!=y_parent);
    }
}