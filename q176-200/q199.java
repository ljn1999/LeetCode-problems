// 2022.05.02
// Problem Statement:
// https://leetcode.com/problems/binary-tree-right-side-view/

// idea: level-order traversal
// https://www.geeksforgeeks.org/level-order-tree-traversal/
// modification: do not print, but update the value for each level intead
// the right most node value will be the final value of level_right_most
// after finish each level, store the level_right_most into answer array

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
    public int getHeight(TreeNode root) {
        if (root==null) return 0;
        int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return height;
    }
    
    public void update_right_most(TreeNode root, int level, int[] level_right_most) {
        if (root == null) return;
        if (level == 1) level_right_most[0] = root.val;
        else if (level > 1) {
            update_right_most(root.left, level-1, level_right_most);
            update_right_most(root.right, level-1, level_right_most);
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List answer = new ArrayList();
        int height = getHeight(root);
        int[] level_right_most = { 0 }; // cannot do pass by reference like C, use length=1 array instead
        for (int level=1; level<=height; level++) {
            update_right_most(root, level, level_right_most);
            answer.add(level_right_most[0]);
        }
        return answer;
    }
}