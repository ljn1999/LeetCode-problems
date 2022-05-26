// 2022.05.26 midnight
// Problem Statement:
// https://leetcode.com/problems/reorganize-string/

// idea: record the count of each char (26 intotal) and rearrange them
class Solution {
    public String reorganizeString(String s) {
        if (s.length()==1) return s;
        int [] count = new int [26];
        int max_char_idx = 0;
        int max_count = 0;
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
            if (count[s.charAt(i)-'a']>max_count) {
                max_count = count[s.charAt(i)-'a'];
                max_char_idx = s.charAt(i)-'a';
            }
        }

        // check for impossible cases
        for (int i=0; i<26; i++) {
            if (2*count[i]-s.length()>=2) return "";
        }

        // fill in even indices then odd indices
        int even = 0, odd = 1;
        int cnt = 0;
        char [] answer = new char [s.length()];
        while (cnt<s.length()) {
            // do the char with the max count to avoid issue like "lvovv" (do l then o finally v)
            for (int j=0; j<count[max_char_idx]; j++) {
                if (s.length()-even>=1) {
                    char temp = 'a';
                    temp += max_char_idx;
                    answer[even] = temp;
                    even += 2;
                    cnt++;
                } else {
                    char temp = 'a';
                    temp += max_char_idx;
                    answer[odd] = temp;
                    odd += 2;
                    cnt++;
                }
            }
            // do the rest char
            for (int i=0; i<26; i++) {
                if (i!=max_char_idx) {
                    for (int j=0; j<count[i]; j++) {
                        if (s.length()-even>=1) {
                            char temp = 'a';
                            temp += i;
                            answer[even] = temp;
                            even += 2;
                            cnt++;
                        } else {
                            char temp = 'a';
                            temp += i;
                            answer[odd] = temp;
                            odd += 2;
                            cnt++;
                        }
                    }
                }
            }
        }
        return String.valueOf(answer);
    }
}