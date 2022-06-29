// 2022.06.29
// Problem Statement:
// https://leetcode.com/problems/house-robber-iii/

// idea: 2 cases: rob root or not, take the max of 2 cases;
// if rob the root, the left and right children cannot be robbed,
// if not rob the root, the left and right children can be robbed, but not necessarily
// use dp to store the max rob value of each node if [rob, not rob], use -1 to initialize
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
    HashMap<TreeNode, int[]> dp;
    public int robHelper(TreeNode root, boolean rob_root) {
        if (root==null) return 0;
        if (dp.containsKey(root)) { // check if calculated before
            if (rob_root && dp.get(root)[0]!=-1) return dp.get(root)[0];
            if (!rob_root && dp.get(root)[1]!=-1) return dp.get(root)[1];
        }
        
        if (rob_root) {
            int ret = (root.val+robHelper(root.left, false)+robHelper(root.right, false));
            if (dp.containsKey(root)) { // already in dp, update idx 0
                int [] curr = dp.get(root);
                curr[0] = ret;
                dp.put(root, curr);
            } else { // not in dp, create new int [] and fill -1 in idx 1
                int [] curr = new int [2];
                curr[0] = ret;
                curr[1] = -1;
                dp.put(root, curr);
            }
            return ret;
        } else {
            int ret = (Math.max(robHelper(root.left, true), robHelper(root.left, false)) +
                       Math.max(robHelper(root.right, true), robHelper(root.right, false)));
            if (dp.containsKey(root)) { // already in dp, update idx 1
                int [] curr = dp.get(root);
                curr[1] = ret;
                dp.put(root, curr);
            } else { // not in dp, create new int [] and fill -1 in idx 0
                int [] curr = new int [2];
                curr[0] = -1;
                curr[1] = ret;
                dp.put(root, curr);
            }
            return ret;
        }
    }
    
    public int rob(TreeNode root) {
        dp = new HashMap<> ();
        return Math.max(robHelper(root, true), robHelper(root, false));
    }
}