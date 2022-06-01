// 2022.06.01 midnight
// Problem Statement:
// https://leetcode.com/problems/guess-the-word/

// idea: a weird heuristic: https://leetcode.com/problems/guess-the-word/discuss/160945/Python-O(n)-with-maximum-overlap-heuristic
// information theory? the most likely answer occurs at the word with the most overlaps (?)
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public int count_diff(String s1, String s2) {
        int cnt = 0;
        for (int i=0; i<6; i++) {
            if (s1.charAt(i)!=s2.charAt(i)) cnt++;
        }
        return cnt;
    }
    
    public String most_overlap(List<String> candidates) {
        int [][] counts = new int [6][26]; // counts[i][j] number of words that 
                                           // satisfies value at idx i is j
        for (String s : candidates) {
            for (int i=0; i<6; i++) {
                counts[i][s.charAt(i)-'a']++;
            }
        }
        int highest_score = 0;
        String ret_word = "";
        for (String s : candidates) {
            int score = 0;
            for (int i=0; i<6; i++) {
                score += counts[i][s.charAt(i)-'a'];
            }
            if (highest_score<=score) {
                highest_score = score;
                ret_word = s;
            }
        }
        return ret_word;
    }
    
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<> ();
        for (String s : wordlist) {
            list.add(s);
        }
        
        while (true) {
            String guess_word = most_overlap(list);
            int match_val = master.guess(guess_word);
            if (match_val==6) return;
            List<String> new_list = new ArrayList<> ();
            for (String s : list) {
                if (count_diff(s, guess_word)==(6-match_val)) {
                    new_list.add(s);
                }
            }
            list = new_list;
        }

        /* TLE solution
        int [][] diff_table = new int [wordlist.length][wordlist.length];
        for (int i=0; i<wordlist.length; i++) {
            for (int j=0; j<wordlist.length; j++) {
                diff_table[i][j] = count_diff(wordlist[i], wordlist[j]);
            }
        }
        
        int guess_idx = 0;
        Set<Integer> s1 = new HashSet<Integer>();
        for (int i=0; i<wordlist.length; i++) {
            s1.add(i);
        }
        Set<Integer> s2 = new HashSet<Integer>();
        
        while (true) {
            int ret = master.guess(wordlist[guess_idx]);
            if (ret==6) return;
            s2.clear();
            for (int i=0; i<wordlist.length; i++) {
                if (diff_table[i][guess_idx]==ret) {
                    s2.add(i);
                }
            }
            s1.retainAll(s2);
            for (Integer idx: s1) {
                guess_idx = idx;
                break;
            }
        } */
    }
}