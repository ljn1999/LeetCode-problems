// 2022.05.10 midnight
// Problem Statement:
// https://leetcode.com/problems/count-complete-tree-nodes/

// idea: first get the height of the tree by continuously goes left
// then check how many nodes are in the bottom level of the tree using level traversal
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
    public void iterateCurrLevel(TreeNode root, int level, int [] answer) {
        if (root==null) return;
        if (level==1) {
            answer[0] = answer[0] + 1;
            return;
        } else {
            iterateCurrLevel(root.left, level-1, answer);
            iterateCurrLevel(root.right, level-1, answer);
            return;
        }
    }
    
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int height = 1;
        TreeNode curr = root;
        while (curr.left!=null) {
            height++;
            curr = curr.left;
        }
        int [] answer = new int [] {(int) Math.pow(2, height-1)-1};
        iterateCurrLevel(root, height, answer);
        return answer[0];
    }
}