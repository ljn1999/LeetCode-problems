// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/reorder-data-in-log-files/

// idea: compare strings, check if the string is an integer, binary insertion
class Solution {
    public boolean largerThan(String str1, String str2) {
        String [] str1_arr = str1.split(" ");
        String [] str2_arr = str2.split(" ");
        for (int i=1; i<Math.min(str1_arr.length, str2_arr.length); i++) {
            if (str1_arr[i].compareTo(str2_arr[i]) > 0) {
                return true;
            } else if (str1_arr[i].compareTo(str2_arr[i]) < 0) {
                return false;
            }
        }
        // compare the length
        if (str1_arr.length>str2_arr.length) return true;
        else if (str1_arr.length<str2_arr.length) return false;
        // compare the identifier
        return str1_arr[0].compareTo(str2_arr[0])>0;
    }
    
    public static boolean isNumeric(String str) { 
        String [] str_list = str.split(" ");
        try {  
            Double.parseDouble(str_list[1]);  
            return true;
        } catch (NumberFormatException e){  
            return false;  
        }  
    }
    
    public List<String> letter_list = new ArrayList<String> ();
    public void insert(String str, int left, int right) {
        left = 0; right = letter_list.size();
        while (left!=right) {
            int mid = (left+right)/2;
            if (largerThan(letter_list.get(mid), str)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        letter_list.add(left, str);
    }
    
    public String[] reorderLogFiles(String[] logs) {
        String [] answer = new String [logs.length];
        int idx = logs.length-1;
        
        for (int i=logs.length-1; i>=0; i--) {
            if (!isNumeric(logs[i])) {
                if (letter_list.size()==0) {
                    letter_list.add(logs[i]);
                } else {
                    // binary search and insert
                    insert(logs[i], 0, letter_list.size()-1);
                }
            } else { // directly add into the answer list
                answer[idx] = logs[i];
                idx--;
            }
        }
        
        for (int i=0; i<letter_list.size(); i++) {
            answer[i] = letter_list.get(i);
        }
        return answer;
    }
}