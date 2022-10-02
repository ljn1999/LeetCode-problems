// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

// idea: dfs to find path to start and path to dest, 
// remove overlapping starts, reverse the path to start,
// merge to get the result
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
    private String reversePath(String s) {
        String ret = "";
        for (int i=0; i<s.length(); i++) {
            ret += "U";
        }
        return ret;
    }
    private boolean dfs(TreeNode root, int target, StringBuilder s) {
        if (root==null) {
            s.deleteCharAt(s.length()-1);
            return false;
        }
        if (root.val==target) {
            return true;
        }
        
        // search left
        if (dfs(root.left, target, s.append("L")) == true) {
            return true;
        }
        // search right
        if (dfs(root.right, target, s.append("R"))==true) {
            return true;
        }
        s.deleteCharAt(s.length()-1);
        return false;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // s: 5 1 3 -> L L (reverse) -> U U
        // d: 5 2 6 -> R L
        // s: 5 1 3 -> 1 3 -> L -> U
        // d: 5 1 7 -> 1 7 -> R
        // s: 5 1 3 -> 1 3
        // d: 5 1 -> 1
        StringBuilder s_s = new StringBuilder();
        StringBuilder d_s = new StringBuilder();
        boolean b = dfs(root, startValue, s_s);
        b = dfs(root, destValue, d_s);
        int i=0;
        for (; i<Math.min(s_s.length(), d_s.length()); i++) {
            if (s_s.charAt(i)!=d_s.charAt(i)) {
                break;
            }
        }
        return reversePath(s_s.substring(i)) + d_s.substring(i);
    }
}