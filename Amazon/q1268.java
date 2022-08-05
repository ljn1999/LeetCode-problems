// 2022.08.06 midnight
// Problem Statement:
// https://leetcode.com/problems/search-suggestions-system/

// idea: build a trie structure, create the trie structure, and search the trie structure
class Solution {
    public class trieNode {
        String str;
        boolean is_word;
        trieNode [] next_char = new trieNode [26];
    }
    
    public void trie_insert(trieNode head, String word) {
        trieNode curr = head;
        for (int i=0; i<word.length(); i++) {
            char curr_char = word.charAt(i);
            if (curr.next_char[curr_char-'a']==null) {
                curr.next_char[curr_char-'a'] = new trieNode ();
                curr.next_char[curr_char-'a'].str = curr.str + Character.toString(curr_char);
            }
            if (i==word.length()-1) {
                curr.next_char[curr_char-'a'].is_word = true;
            }
            curr = curr.next_char[curr_char-'a'];    
        }
    }
    
    public void trie_search(trieNode start, int cnt, List<String> curr_answer) {
        if (cnt<=0) return;
        if (start.is_word) { // base case
            curr_answer.add(start.str);
            cnt--;
        }
        for (int i=0; i<26; i++) {
            if (cnt>0) {
                if (start.next_char[i]!=null) {
                    trie_search(start.next_char[i], cnt, curr_answer);
                    cnt = 3-curr_answer.size(); // upadte count
                }
            } else {
                return;
            }
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // build the trie
        trieNode head = new trieNode();
        head.str = "";
        head.is_word = false;
        for (String s: products) {
            trie_insert(head, s);
        }
        
        // search for the word
        List<List<String>> answer = new ArrayList<> ();
        boolean not_found = false;
        trieNode curr = head;
        for (int i=0; i<searchWord.length(); i++) {
            if (not_found) {
                answer.add(new ArrayList<> ());
                continue;
            }
            char curr_char = searchWord.charAt(i);
            curr = curr.next_char[curr_char-'a'];
            List<String> curr_answer = new ArrayList<> ();
            if (curr==null) {
                answer.add(curr_answer);
                not_found = true;
                continue;
            }
            trie_search(curr, 3, curr_answer);
            answer.add(curr_answer);
        }
        return answer; 
    }
}