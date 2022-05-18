// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/word-ladder/

// idea: BFS, propogating the next reachable string and mark it as visited, do not consider it again,
// the number of steps is already the optimized one
// another idea: using 2-end BFS, simutaniously searching from beginning to end and from end to beginning
// https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
class Solution {
    public Map <String, Integer> ht = new HashMap <String, Integer> ();
    
    public boolean singleDiff(String str1, String str2) {
        int count_diff = 0;
        for (int i=0; i<str1.length(); i++) {
            if (str1.charAt(i)!=str2.charAt(i)) {
                count_diff++;
                if (count_diff>=2) return false;
            }
        }
        return true;
    }
    
    /* DFS - TLE
    public int ladderLengthHelper(String beginWord, String endWord, List<String> wordList) {
        boolean no_sol = true;
        int curr = Integer.MAX_VALUE;
        for (int i=0; i<wordList.size(); i++) {
            String word = wordList.get(i);
            if (singleDiff(beginWord, word)) { 
                if (word.equals(endWord)) return 1;
                wordList.remove(word);
                int temp;
                if (ht.containsKey(word)) {
                    temp = ht.get(word);
                } else {
                    temp = ladderLengthHelper(word, endWord, wordList);
                }
                wordList.add(i, word);
                if (temp!=0) {
                    curr = Math.min(curr, temp);
                }
            }
        }
        if (curr==Integer.MAX_VALUE) {
            ht.put(beginWord, 0);
            return 0;
        }
        ht.put(beginWord, curr+1);
        return curr+1;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.contains(beginWord)) {
            String obj = beginWord;
            wordList.remove(obj);
        }
        
        int answer = ladderLengthHelper(beginWord, endWord, wordList);
        if (answer==0) return 0;
        return answer+1;
    }
    */
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.contains(beginWord)) {
            String obj = beginWord;
            wordList.remove(obj);
        }
        HashSet<String> done_words = new HashSet<String>();
        List<String> done_words_new = new ArrayList<String> ();
        done_words.add(beginWord);
        done_words_new.add(beginWord);
        boolean no_sol = true;
        int count = 1;
        while (true) {
            count++;
            no_sol = true;
            int size = done_words_new.size();
            for (int i=0; i<size; i++) {
                String first_word = done_words_new.get(i);
                for (int j=0; j<wordList.size(); j++) {
                    String word = wordList.get(j);
                    if (!done_words.contains(word)) {
                        if (singleDiff(first_word, word)) {
                            no_sol = false;
                            if (word.equals(endWord)) return count;
                            ht.put(word, count);
                            done_words.add(word);
                            done_words_new.add(word);
                        }
                    }
                }
            }
            done_words_new.subList(0, size).clear();
            if (no_sol) return 0;
        }
    }
}