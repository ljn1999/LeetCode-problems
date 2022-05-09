// 2022.05.08
// Problem Statement:
// https://leetcode.com/problems/shortest-palindrome/

// idea: https://leetcode.com/problems/shortest-palindrome/discuss/60113/Clean-KMP-solution-with-super-detailed-explanation
// KMP algorithm, the loopup table's last element is the length of the longest palindrome starting from index 0
class Solution {
    public int [] kmp(String str) {
        int [] kmp_table = new int [str.length()];
        kmp_table[0] = 0;
        int idx = 0; // end idx for the prefix
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i)==str.charAt(idx)) {
                kmp_table[i] = kmp_table[i-1]+1;
                idx++;
            } else {
                idx = kmp_table[i-1];
                while (idx>0 && str.charAt(i)!=str.charAt(idx)) {
                    idx = kmp_table[idx-1]; // keep shortening the prefix
                }
                // check the last match
                if (str.charAt(i)==str.charAt(idx)) {
                    idx++;
                }
                kmp_table[i] = idx;
            }
        } 
        return kmp_table;
    }
    public String shortestPalindrome(String s) {
        // equivalent: find the longest palindrom which starts at s[0]
        // then make up the rest in the front
        
        // make a new str to force str matching from idx=0
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int [] kmp_table = kmp(str);
        
        String answer = "";
        for (int i=0; i<s.length() - kmp_table[kmp_table.length-1]; i++) {
            answer = answer + s.substring(s.length()-1-i, s.length()-i);
        }
        answer = answer + s;
        return answer;
        
        /* TLE solution
        List<Character> char_list = new ArrayList<>();
        List<Character> char_list_reversed = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            char_list.add(s.charAt(i));
            char_list_reversed.add(s.charAt(s.length()-1-i));
        }
        for (int i=0; i<s.length(); i++) {
            // start compare
            boolean found = true;
            for (int j=0; j<char_list_reversed.size(); j++) {
                if (char_list_reversed.get(j) != s.charAt(j)) {
                    found = false;
                    break;
                }
            }            
            if (found) {
                break;
            }            
            char_list_reversed.remove(0);
        }
        if (char_list_reversed.size()==s.length()) {
            System.out.println("here");
            return s;
        }
        //System.out.println(char_list_reversed.size());
        String answer = "";
        for (int i=0; i<s.length() - char_list_reversed.size(); i++) {
            answer = answer + s.substring(s.length()-1-i, s.length()-i);
        }
        answer = answer + s;
        return answer;
        */
    }
}