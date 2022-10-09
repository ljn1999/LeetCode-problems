// 2022.10.08
// Problem Statement:
// https://leetcode.com/problems/keyboard-row/

// idea: check if there's any change in rows, include 3 rows together
class Solution {
    public String[] findWords(String[] words) {
        String r1 = "qwertyuiopQWERTYUIOP";
        String r2 = "asdfghjklASDFGHJKL";
        String r3 = "zxcvbnmZXCVBNM";
        List<String> s_l = new ArrayList<String> ();
        for (String w : words) {
            int line_num = -1;
            boolean can_form = true;
            for (int i=0; i<w.length(); i++) {
                if (r1.contains(String.valueOf(w.charAt(i)))) {
                    if (line_num==-1 || line_num==1) {
                        line_num = 1;
                    } else {
                        can_form = false;
                        break;
                    }
                } else if (r2.contains(String.valueOf(w.charAt(i)))) {
                    if (line_num==-1 || line_num==2) {
                        line_num = 2;
                    } else {
                        can_form = false;
                        break;
                    }
                } else {
                    if (line_num==-1 || line_num==3) {
                        line_num = 3;
                    } else {
                        can_form = false;
                        break;
                    }
                }
            }
            if (can_form) {
                s_l.add(w);
            }
        }
        String [] answer = new String [s_l.size()];
        for (int i=0; i<s_l.size(); i++) {
            answer[i] = s_l.get(i);
        }
        return answer;
    }
}