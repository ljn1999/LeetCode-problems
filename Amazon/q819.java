// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/most-common-word/

// idea: seperate the words to array, build a dictionary to track the count
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        int cnt_max = 0;
        String answer = "";
        String [] str_array = paragraph.split("[', !?.;]+"); // split at ', !?.; for one or more times
        if (str_array.length==1) return str_array[0].toLowerCase();
        Map <String, Integer> ht = new HashMap <String, Integer> ();
        for (int i=0; i<str_array.length; i++) {
            if (!Arrays.asList(banned).contains(str_array[i].toLowerCase())) {
                if (ht.containsKey(str_array[i].toLowerCase())) {
                    ht.put(str_array[i].toLowerCase(), ht.get(str_array[i].toLowerCase())+1);
                    if (ht.get(str_array[i].toLowerCase())>cnt_max) { // update count and return string
                        cnt_max = ht.get(str_array[i].toLowerCase());
                        answer = str_array[i].toLowerCase();
                    }
                } else {
                    ht.put(str_array[i].toLowerCase(), 1);
                    if (1>cnt_max) { // update count and return string
                        cnt_max = 1;
                        answer = str_array[i].toLowerCase();
                    }
                }
            }
        }
        return answer;
    }
}