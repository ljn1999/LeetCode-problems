// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/binary-tree-paths/

// idea: recursion, paths(root) = append root to all paths(root.left) & paths(root.right)
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) return null;
        
        List<String> curr_answer = new ArrayList<String> ();
        if (root.left==null & root.right==null) {
            curr_answer.add(Integer.toString(root.val));
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        if (left!=null) {
            for (int i=0; i<left.size(); i++) {
                curr_answer.add(Integer.toString(root.val)+"->"+left.get(i));
            }
        }
        if (right!=null) {
            for (int i=0; i<right.size(); i++) {
                curr_answer.add(Integer.toString(root.val)+"->"+right.get(i));
            }
        }
        return curr_answer;
    }
}