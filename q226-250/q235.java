// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// idea: the lowest common ancestor is found if p and q are on a node's left and right subtrees,
// or the node's value equals p or q
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr!=null) {
            if (curr.val==p.val || curr.val==q.val) return curr;
            else if ((curr.val-p.val)*(curr.val-q.val)<0) { // p and q are on left and right subtrees
                return curr;
            } else if (curr.val>p.val && curr.val>q.val) { // search the left subtree
                curr = curr.left;
            } else { // search the right subtree
                curr = curr.right;
            }
        }
        return null;
    }
}