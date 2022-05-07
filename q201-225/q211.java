// 2022.05.07
// Problem Statement:
// https://leetcode.com/problems/design-add-and-search-words-data-structure/

// idea: similar as q208
// when doing search, use recursion method
public class TreeNode {
    char c;
    boolean complete_word;
    TreeNode [] next_char = new TreeNode [26]; // 26 letters
    TreeNode() {};
    TreeNode(char c) {
        this.c = c;
    }
}

class WordDictionary {
    public TreeNode root;
    public WordDictionary() {
        root = new TreeNode(' ');
    }
    
    public void addWord(String word) {
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
    
    public boolean searchHelp(TreeNode root, String word) {
        if (word.length()==0) return root.complete_word;
        char curr_char = word.charAt(0);
        if (curr_char != '.') {
            if (root.next_char[curr_char-'a'] == null) {
                return false;
            } else {
                return searchHelp(root.next_char[curr_char-'a'], word.substring(1));
            }
        } else {
            boolean temp = false;
            for (int i=0; i<26; i++) {
                if (root.next_char[i] != null) {
                    temp = searchHelp(root.next_char[i], word.substring(1));
                    if (temp) return true; // once a single child can match, return true
                }
            }
            return false;
        }
    }
    
    public boolean search(String word) {
        return searchHelp(root, word);   
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */