// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/implement-trie-prefix-tree/

// idea: https://leetcode.com/problems/implement-trie-prefix-tree/discuss/58832/AC-JAVA-solution-simple-using-single-array
// store every single char instead of the entire string
public class TreeNode {
    char c;
    boolean complete_word;
    TreeNode [] next_char = new TreeNode [26]; // 26 letters
    TreeNode() {};
    TreeNode(char c) {
        this.c = c;
    }
}

class Trie {
    public TreeNode root;
    public Trie() {
        root = new TreeNode(' ');
    }
    
    public void insert(String word) {
        TreeNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char curr_char = word.charAt(i);
            if (curr.next_char[curr_char-'a'] != null) {
                curr = curr.next_char[curr_char-'a'];
            } else {
                TreeNode new_node = new TreeNode(curr_char);
                curr.next_char[curr_char-'a'] = new_node;
                curr = curr.next_char[curr_char-'a'];
            }
        }
        curr.complete_word = true;
    }
    
    public boolean search(String word) {
        TreeNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char curr_char = word.charAt(i);
            if (curr.next_char[curr_char-'a'] == null) {
                return false;
            } else {
                curr = curr.next_char[curr_char-'a'];
            }
        }
        return curr.complete_word;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (int i=0; i<prefix.length(); i++) {
            char curr_char = prefix.charAt(i);
            if (curr.next_char[curr_char-'a'] == null) {
                return false;
            } else {
                curr = curr.next_char[curr_char-'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */