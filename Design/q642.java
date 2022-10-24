// 2022.10.23
// Problem Statement:
// https://leetcode.com/problems/design-search-autocomplete-system/

// idea: Trie + search
class TrieNode {
    String sen;
    TrieNode [] child;
    int hot;
    HashSet<String> l;
    TrieNode () {
        sen = "";
        hot = 0;
        child = new TrieNode[27];
        l = new HashSet<> (); // all candidates starting with this prefix
    }
}
class AutocompleteSystem {
    private TrieNode root;
    private String str;
    private TrieNode s_ptr;
    private HashMap<String, Integer> ht;
    private void insert_to_trie(String s, int time) {
        TrieNode curr = root;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ') {
                if (curr.child[26]==null) {
                    curr.child[26] = new TrieNode();
                }
                curr = curr.child[26];
                curr.l.add(s);
            } else {
                if (curr.child[s.charAt(i)-'a']==null) {
                    curr.child[s.charAt(i)-'a'] = new TrieNode();
                }
                curr = curr.child[s.charAt(i)-'a'];
                curr.l.add(s);
            }
        }
        curr.sen = s;
        curr.hot = Math.max(time, curr.hot+1);
        ht.put(curr.sen, curr.hot);
    }
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        // build the trie
        root = new TrieNode(); // dummy root
        ht = new HashMap<> ();
        for (int i=0; i<sentences.length; i++) {
            insert_to_trie(sentences[i], times[i]);
            ht.put(sentences[i], times[i]);
        }
        s_ptr = root;
        str = "";
        return;
    }

    public List<String> input(char c) {
        if (c!='#') {
            str = str + String.valueOf(c);
            // search here
            if (s_ptr==null) { // cannot find
                return new ArrayList<String> ();
            }
            if (c!=' ') s_ptr = s_ptr.child[c-'a'];
            else s_ptr = s_ptr.child[26];
            if (s_ptr==null) { // cannot find
                return new ArrayList<String> ();
            } else {
                // at least one solution
                // build a priority queue of size 3, min heap
                PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<> (new Comparator<Map.Entry<String, Integer>>() {
                    // sort by time and alphabetical order
                    @Override
                    public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                        if (m1.getValue() < m2.getValue()) return -1;
                        else if (m1.getValue() > m2.getValue()) return 1;
                        else {
                            if (m1.getKey().compareTo(m2.getKey()) < 0) {
                                return 1;
                            }
                            else return -1;
                        }
                    }
                });
                HashSet<String> l_s = s_ptr.l;
                for (String s : l_s) {
                    Map.Entry<String, Integer> new_entry = Map.entry(s, ht.get(s));
                    q.offer(new_entry);
                    if (q.size()>3) {
                        q.poll();
                    }
                }
                List<String> ret = new ArrayList<> ();
                while (!q.isEmpty() && ret.size()<3) {
                    ret.add(0, q.peek().getKey());
                    q.poll();
                }
                return ret;
            }
        } else {
            insert_to_trie(str, 1);
            // reset s_ptr and str
            s_ptr = root;
            str = "";
            return new ArrayList<String> ();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */