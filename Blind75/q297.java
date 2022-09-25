// 2022.09.24
// Problem Statement:
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// idea: level order traversal (bfs), can also use pre-order traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // level order traversal
        if (root==null) return "";
        String s = "";
        Queue <TreeNode> q = new LinkedList<> ();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode curr_node = q.poll();
                if (curr_node==null) {
                    s += "/null";
                } else {
                    s += "/";
                    s += String.valueOf(curr_node.val);
                    q.add(curr_node.left);
                    q.add(curr_node.right);
                }
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String [] s_list = data.substring(1).split("/");
        TreeNode answer = new TreeNode(Integer.valueOf(s_list[0]));
        TreeNode curr = answer;
        Queue <TreeNode> q = new LinkedList<> ();
        q.add(answer);
        int i = 1;
        while (i<s_list.length-1) {
            curr = q.poll();
            if (curr!=null) {
                if (s_list[i].equals("null")) {
                    curr.left = null;
                    q.add(null);

                } else {
                    curr.left = new TreeNode (Integer.valueOf(s_list[i]));
                    q.add(curr.left);
                }
                i++;
                if (s_list[i].equals("null")) {
                    curr.right = null;
                    q.add(null);
                } else {
                    curr.right = new TreeNode (Integer.valueOf(s_list[i]));
                    q.add(curr.right);
                }
                i++;
            }
        }
        return answer;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));