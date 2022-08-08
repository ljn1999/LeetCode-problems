// 2022.08.08
// Problem Statement:
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

// idea: build a hashmap with coordinate as key and list of val as values,
// do dfs to insert into the hashmap, and iterate all possible coordinates to append to the answer
// a better one using TreeMap and Priority Queue: 
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231148/Java-TreeMap-Solution
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
    public HashMap<List<Integer>, ArrayList> ht;
    public int min_row;
    public int max_row;
    public int min_col;
    public int max_col;

    public void verticalTraversalHelper(TreeNode root, int row, int col) {
        if (root==null) return;
        // insert to ht
        min_row = Math.min(min_row, row);
        max_row = Math.max(max_row, row);
        min_col = Math.min(min_col, col);
        max_col = Math.max(max_col, col);
        
        List<Integer> coordinate = new ArrayList<> ();
        coordinate.add(row);
        coordinate.add(col);
        
        if (ht.containsKey(coordinate)) {
            ht.get(coordinate).add(root.val);
        } else {
            ArrayList <Integer> new_list = new ArrayList<> ();
            new_list.add(root.val);
            ht.put(coordinate, new_list);
        }
        
        // do children
        if (root.left!=null) {
            verticalTraversalHelper(root.left, row+1, col-1);
        }
        if (root.right!=null) {
            verticalTraversalHelper(root.right, row+1, col+1);
        }
        return;
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ht = new HashMap<> ();
        max_row=0; min_row=0; max_col=0; min_col=0;
        
        verticalTraversalHelper(root, 0, 0);

        List<List<Integer>> answer = new ArrayList<> ();
        for (int i=min_col; i<=max_col; i++) {
            boolean is_first = true; // is the first node in this column
            for (int j=min_row; j<=max_row; j++) {
                List<Integer> coordinate = new ArrayList<> ();
                coordinate.add(j);
                coordinate.add(i);
                if (ht.containsKey(coordinate)) {
                    Collections.sort(ht.get(coordinate));
                    if (is_first) { // start with another arraylist
                        answer.add(ht.get(coordinate));
                        is_first = false;
                    } else { // continue on the same arraylist
                        answer.get(answer.size()-1).addAll(ht.get(coordinate));
                    }
                    
                }
            }
        }
        return answer;
    }
}