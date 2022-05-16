// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// idea: pre-order traversal and pre-order build
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
    public String data = "";
    public void serializeHelper(TreeNode root) {
        if (root==null) {
            data = data + " null";
        } else {
            data = data + " " + Integer.toString(root.val);
            serializeHelper(root.left);
            serializeHelper(root.right);
            return;
        }
    }
    public String serialize(TreeNode root) {
        if (root==null) return "";
        serializeHelper(root);
        data = data.substring(1);
        return data;
    }

    // Decodes your encoded data to tree.
    public int idx = 0;
    public TreeNode deserializeHelper(TreeNode root, String[] str_list) {
        if (str_list[idx].equals("null")) {
            idx++;
            return null;
        }
        root.val = Integer.parseInt(str_list[idx]);
        idx++; // increase idx everytime a value is put in, even it's null
        root.left = deserializeHelper(new TreeNode (), str_list);
        root.right = deserializeHelper(new TreeNode (), str_list);
        return root;
    }
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String[] str_list = data.split("\\s+");
        TreeNode root = new TreeNode ();
        deserializeHelper(root, str_list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));