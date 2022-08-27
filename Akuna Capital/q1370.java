// 2022.08.27
// Problem Statement:
// https://leetcode.com/problems/increasing-decreasing-string/

// idea 1: sort the characters, and move the index and pick the needed ones;
// idea 2: store the counts in an array of 26 elements, move the index in the array
// and see if there are available characters left there
class Solution {
    public String sortString(String s) {
        // method 1:
        // sort the chars in s and put into an arraylist
        char [] char_arr = s.toCharArray();
        Arrays.sort(char_arr);
        List<Character> char_arr_list = new ArrayList<Character> ();
        for (int ia=0; i<char_arr.length; i++) {
            char_arr_list.add(char_arr[i]);
        }

        String answer = "";
        while (char_arr_list.size()>0) {
            // step 1-3
            int idx = 0;
            char curr_char = '0';
            while (idx<char_arr_list.size()) {
                if (curr_char!=char_arr_list.get(idx)) { // no continuous characters
                    answer = answer + Character.toString(char_arr_list.get(idx));
                    curr_char = char_arr_list.get(idx);
                    char_arr_list.remove(idx);
                    // no need to increase idx as one element is removed from the arraylist
                } else {
                    idx++;
                }
            }
            // step 4-6
            idx = char_arr_list.size()-1;
            curr_char = '0';
            while (idx>=0) {
                if (curr_char!=char_arr_list.get(idx)) { // no continuous characters
                    answer = answer + Character.toString(char_arr_list.get(idx));
                    curr_char = char_arr_list.get(idx);
                    char_arr_list.remove(idx);
                }
                idx--;
            }
        }
        return answer;
        
        /* method 2:
        int [] char_cnt = new int [26];
        for (int i=0; i<s.length(); i++) {
            char_cnt[s.charAt(i)-'a']++;
        }
        
        int curr_length = 0;
        String answer = "";
        while (curr_length!=s.length()) {
            // step 1-3
            int idx = 0;
            while (idx<26) {
                if (char_cnt[idx]>0) {
                    answer = answer + Character.toString('a'+idx);
                    curr_length++;
                    char_cnt[idx]--;
                }
                idx++;
            }
            // step 4-6
            idx = 25;
            while (idx>=0) {
                if (char_cnt[idx]>0) {
                    answer = answer + Character.toString('a'+idx);
                    curr_length++;
                    char_cnt[idx]--;
                }
                idx--;
            }
        }
        return answer;
        */
    }
}