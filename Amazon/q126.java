// 2022.05.18
// Problem Statement:
// https://leetcode.com/problems/word-ladder-ii/

// idea: bfs with queue of path, instead of queue nodes
// https://leetcode.com/problems/word-ladder-ii/discuss/40434/C%2B%2B-solution-using-standard-BFS-method-no-DFS-or-backtracking
class Solution {
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
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.contains(beginWord)) {
            String obj = beginWord;
            wordList.remove(obj);
        }

        int level = 1;
        int shortest = Integer.MAX_VALUE;
        List<List<String>> answer = new ArrayList<> ();
        Queue<List<String>> queue = new LinkedList<> ();
        List<String> temp = new ArrayList<> ();
        temp.add(beginWord);
        queue.add(temp);
        HashSet<String> visited = new HashSet<> ();

        outerloop:
        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            if (path.size()>level) { // reach a new level, remove all visited nodes from wordList
                for (String word : visited) {
                    wordList.remove(word);
                }
                visited.clear();
                if (path.size()>shortest) {
                    break outerloop;
                } else {
                    level = path.size();
                }
            }
            String last_word = path.get(path.size()-1);
            for (int i=0; i<wordList.size(); i++) {
                String word = wordList.get(i);
                if (singleDiff(last_word, word)) {
                    visited.add(word);
                    path.add(word);
                    if (word.equals(endWord)) {
                        shortest = level;
                        answer.add(new ArrayList<>(path));
                    } else {
                        queue.add(new ArrayList<>(path));
                    }
                    path.remove(word);
                }
            }
        }
        return answer;
    }
}