// 2022.09.20
// Problem Statement:
// https://leetcode.com/problems/alien-dictionary/

// idea: directed & unweighted graph check cyclic or not -> bfs with in-degrees
class Solution {
    public String alienOrder(String[] words) {
        // build graph, key: char, val: chars larger than key
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<> ();
        for (int i=0; i<words.length-1; i++) {
            int idx = 0;
            while (idx<Math.min(words[i].length(), words[i+1].length()) && words[i].charAt(idx)==words[i+1].charAt(idx)) {
                idx++;
            }
            if (idx<words[i].length() && idx<words[i+1].length()) {
                graph.putIfAbsent(words[i].charAt(idx)-'a', new HashSet<Integer> ());
                graph.get(words[i].charAt(idx)-'a').add(words[i+1].charAt(idx)-'a');
            } else if (idx<words[i].length() && idx==words[i+1].length()) {
                return "";
            }
        }
        
        // get the entire dict
        HashSet<Integer> set = new HashSet<> ();
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                set.add(words[i].charAt(j)-'a');
            }
        }
        
        // build in-degrees
        int [] degrees = new int [26];
        for (int i=0; i<26; i++) {
            if (!set.contains(i)) degrees[i] = -1;
        }
        for (int i : graph.keySet()) {
            for (int j : graph.get(i)) {
                if (degrees[j]==-1) degrees[j]=0;
                degrees[j]++;
            }
        }
        
        // do cyclic check
        String answer = "";
        for (int c=0; c<set.size(); c++) {
            int i=0;
            for (; i<26; i++) {
                if (degrees[i]==0) {
                    answer = answer + Character.toString(i+'a');
                    degrees[i]--;
                    if (graph.containsKey(i)) {
                        for (int n : graph.get(i)) {
                            degrees[n]--;
                        }
                    }
                }
                
            }
        }
        if (answer.length()!=set.size()) return "";
        return answer;
    }
}