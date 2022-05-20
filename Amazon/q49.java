// 2022.05.19 midnight
// Problem Statement:
// https://leetcode.com/problems/group-anagrams/

// idea: build a 2d array to store the number of each char in each string, 
// compare the arrays for each char to detect a group
// another idea: sort all the strings and build a map
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int [][] count = new int [strs.length][26];
        for (int i=0; i<strs.length; i++) {
            String s = strs[i];
            for (int j=0; j<s.length(); j++) {
                count[i][s.charAt(j)-'a']++;
            }
        }
        
        List<List<Integer>> answer = new ArrayList<> ();
        List<Integer> temp = new ArrayList<Integer> ();
        for (int i=0; i<strs.length; i++) {
            boolean flag = true;
            if (answer.size()==0) {
                temp.add(i);
                answer.add(temp);
                temp = new ArrayList<Integer> ();
            } else {
                for (int j=0; j<answer.size(); j++) {
                    if (Arrays.equals(count[answer.get(j).get(0)], count[i])) {
                        answer.get(j).add(i);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    temp = new ArrayList<Integer> ();
                    temp.add(i);
                    answer.add(temp);
                }
            }
        }
        
        List<List<String>> answer_ret = new ArrayList<> ();
        for (int i=0; i<answer.size(); i++) {
            List<String> temp2 = new ArrayList<String> ();
            for (int j=0; j<answer.get(i).size(); j++) {
                temp2.add(strs[answer.get(i).get(j)]);
            }
            answer_ret.add(temp2);
        }
        return answer_ret;
    }
}