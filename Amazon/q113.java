// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/path-sum-ii/

// idea: recursion, search left and/or right, with targetSum-root.val
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // base case 1
        if (root==null) return new ArrayList<> ();
        List<List<Integer>> answer = new ArrayList<> ();
        // base case 2
        if (root.left==null && root.right==null) {
            if (targetSum==root.val) {
                List<Integer> one_node = new ArrayList<> ();
                one_node.add(root.val);
                answer.add(one_node);
                return answer;
            } else {
                return answer;
            }
        }
        if (root.left!=null) {
            List<List<Integer>> left = pathSum(root.left, targetSum-root.val);
            for (List l_list : left) {
                l_list.add(0, root.val);
                answer.add(l_list);
            }
        }
        if (root.right!=null) {
            List<List<Integer>> right = pathSum(root.right, targetSum-root.val);
            for (List r_list : right) {
                r_list.add(0, root.val);
                answer.add(r_list);
            }
        }
        return answer;
    }
}