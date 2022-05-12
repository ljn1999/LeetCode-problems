// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// idea: find the path of p and q respectively and go through their common path to reach the lowest common ancestor
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
    public boolean found = false;
    public void findPath(TreeNode root, TreeNode x, List<Boolean> is_left) {
        if (root==null) return;
        if (root.val==x.val) {
            found = true;
            return;
        }

        // search the left
        is_left.add(true);
        findPath(root.left, x, is_left);
        if (found) return;
        is_left.remove(is_left.size()-1);
        
        // search the right
        is_left.add(false);
        findPath(root.right, x, is_left);
        if (found) return;
        is_left.remove(is_left.size()-1);
        
        return; 
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Boolean> path_p = new ArrayList<Boolean> ();
        findPath(root, p, path_p);
        found = false; // have to reset found to false

        List<Boolean> path_q = new ArrayList<Boolean> ();
        findPath(root, q, path_q);
        
        TreeNode curr = root;
        int i = 0;
        while (i<Math.min(path_p.size(), path_q.size()) && path_p.get(i)==path_q.get(i)) {
            if (path_p.get(i)) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            i++;
        }
        return curr;
    }
}