// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// idea: in order traversal
// if can edit the TreeNode structure, add count = nodes below the current node
// when curr_node.left.count == k-1, return curr_node.val
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63659/What-if-you-could-modify-the-BST-node's-structure
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
    public void in_order_traversal(TreeNode root, List<Integer> vals) {
        if (root.left!=null) in_order_traversal(root.left, vals);
        vals.add(root.val);
        if (root.right!=null) in_order_traversal(root.right, vals);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        // in order traversal
        List<Integer> vals = new ArrayList<Integer> ();
        in_order_traversal(root, vals);
        int k_th = vals.get(k-1);
        return k_th;
    }
}