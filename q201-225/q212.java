// 2022.05.08
// Problem Statement:
// https://leetcode.com/problems/word-search-ii/

// idea: pure dfs method is too slow, have to use trie (prefix tree) method
// Trie structure: the given words, so that the cell-prefix match can be "cached"
public class TreeNode {
    String word; // stores word instead of char, it marks a complete word, otherwise it's null
    TreeNode [] next_char = new TreeNode [26]; // 26 letters
    TreeNode() {};
    TreeNode(String word) {
        this.word = word;
    }
}

class Solution {
    public TreeNode root = new TreeNode();
    public void findWordHelper(int start_x, int start_y, char [][] board, TreeNode node, List<String> answer) {
        if (start_x<0 || start_x>board.length || start_y<0 || start_y>board[0].length) return;
        char temp = board[start_x][start_y];
        if (temp == '.' || node.next_char[temp-'a'] == null) return; // if visited already or no match
        node = node.next_char[temp-'a'];
        
        if (node.word != null) {
            answer.add(node.word);
            node.word = null; // avoid duplication, once stored never detected again
        }
        
        board[start_x][start_y] = '.'; // mark as visited
        
        // left
        if (!(start_x<1)) {
            findWordHelper(start_x-1, start_y, board, node, answer);
        }
        // right
        if (!(start_x>=board.length-1)) {
            findWordHelper(start_x+1, start_y, board, node, answer);
        }
        // top
        if (!(start_y<1)) {
            findWordHelper(start_x, start_y-1, board, node, answer);
        }
        // bottom
        if (!(start_y>=board[0].length-1)) {
            findWordHelper(start_x, start_y+1, board, node, answer);
        }
        board[start_x][start_y] = temp; // mark as unvisited for the next round of iteration
        return;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        boolean [][] visited = new boolean [board.length][board[0].length];
        List<String> answer = new ArrayList<String> ();
        
        // trie (prefix tree)
        // build String[] words as a trie
        for (String str : words) {
            TreeNode curr = root;
            for (char c: str.toCharArray()) {
                if (curr.next_char[c-'a'] == null) {
                    curr.next_char[c-'a'] = new TreeNode();
                }
                curr = curr.next_char[c-'a'];
            }
            curr.word = str; // when a word completes, store in the last node
        }
        
        // do the search, every cell can be the starting cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWordHelper(i, j, board, root, answer);
            }
        }
        return answer;
    }
}

// dfs method which got a TLE
/* class Solution {
    public boolean findWordHelper(int start_x, int start_y, char [][] board, boolean [][] visited, String word) {
        if (start_x<0 || start_x>board.length || start_y<0 || start_y>board[0].length) return false;
        if (word.length()==1) return (!visited[start_x][start_y]) 
                                     && (board[start_x][start_y] == word.charAt(0));
        if (!(board[start_x][start_y] == word.charAt(0))) return false;
        
        visited[start_x][start_y] = true;
        // left
        if (!(start_x<1) && !visited[start_x-1][start_y]) {
            boolean left = findWordHelper(start_x-1, start_y, board, visited, word.substring(1));
            if (left) return true;
        }
        // right
        if (!(start_x>=board.length-1) && !visited[start_x+1][start_y]) {
            boolean right = findWordHelper(start_x+1, start_y, board, visited, word.substring(1));
            if (right) return true;
        }
        // top
        if (!(start_y<1) && !visited[start_x][start_y-1]) {
            boolean top = findWordHelper(start_x, start_y-1, board, visited, word.substring(1));
            if (top) return true;
        }
        // bottom
        if (!(start_y>=board[0].length-1) && !visited[start_x][start_y+1]) {
            boolean bottom = findWordHelper(start_x, start_y+1, board, visited, word.substring(1));
            if (bottom) return true;
        }
        visited[start_x][start_y] = false;
        return false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        boolean [][] visited = new boolean [board.length][board[0].length];
        List<String> answer = new ArrayList<String> ();
        for (int word_idx=0; word_idx<words.length; word_idx++) {
            String curr_word = words[word_idx];
            boolean has_answer = false;
            start_point_loop:
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    has_answer = findWordHelper(i, j, board, visited, curr_word);
                    if (has_answer) {
                        answer.add(curr_word);
                        break start_point_loop;
                    }
                }
            }
            visited = new boolean [board.length][board[0].length];
        }
        return answer;
    }
} */