// 2022.09.25 midnight
// Problem Statement:
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// idea: for each node, find its index in inorder, and everything btw left bound and index is left tree,
// and everything btw index and right bound goes to the right tree,
// build left subtree and right subtree and merge and return
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
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
    public HashMap<Integer, Integer> ht;
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int p_start, int i_start, int i_end) {
        // base cases to stop
        if (i_start>i_end) return null;
        if (p_start>=preorder.length) return null;
        
        TreeNode new_node = new TreeNode (preorder[p_start]);
        int idx = ht.get(preorder[p_start]);
        // left child is p_start+1 in preorder
        TreeNode left = buildTreeHelper(preorder, inorder, p_start+1, i_start, idx-1);
        // right child's index is 1+left tree's nodes number apart from p_start
        TreeNode right = buildTreeHelper(preorder, inorder, p_start+idx-i_start+1, idx+1, i_end); 
        
        new_node.left = left;
        new_node.right = right;
        return new_node;
        
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ht = new HashMap<> ();
        for (int i=0; i<inorder.length; i++) {
            ht.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length-1);
    }
}