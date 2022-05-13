// 2022.05.13 midnight
// Problem Statement:
// https://leetcode.com/problems/integer-to-english-words/

// idea: stupid recusion method, 3 digits as a chunck
class Solution {
    public Map<Integer, String> int_word = new HashMap<Integer, String> ();
    public String answer = "";
    public String numberToWordsHelper(int num) {
        if (num==0) {
            return "";
        }
        int num_digits = (int) Math.log10(num)+1;
        if (num_digits>9) {
            if (num%(int)Math.pow(10, 9)==0) {
                answer = int_word.get(num/(int)Math.pow(10, 9)) + " Billion";
            } else {
                answer = int_word.get(num/(int)Math.pow(10, 9)) + " Billion " 
                         + numberToWordsHelper(num%(int)Math.pow(10, 9));
            }
            return answer;
        } else if (num_digits>6) {
            if (num%(int)Math.pow(10, 6)==0) {
                answer = numberToWordsHelper(num/(int)Math.pow(10, 6)) + " Million";
            } else {
                answer = numberToWordsHelper(num/(int)Math.pow(10, 6)) + " Million " 
                         + numberToWordsHelper(num%(int)Math.pow(10, 6));
            }
        } else if (num_digits>3) {
            if (num%(int)Math.pow(10, 3)==0) {
                answer = numberToWordsHelper(num/(int)Math.pow(10, 3)) + " Thousand";
            } else {
                answer = numberToWordsHelper(num/(int)Math.pow(10, 3)) + " Thousand " 
                         + numberToWordsHelper(num%(int)Math.pow(10, 3));
            }
        } else if (num_digits==3) {
            if (num%(int)Math.pow(10, 2)==0) {
                answer = int_word.get(num/(int)Math.pow(10, 2)) + " Hundred";
            } else {
                answer = int_word.get(num/(int)Math.pow(10, 2)) + " Hundred "
                         + numberToWordsHelper(num%(int)Math.pow(10, 2));
            }
        } else if (num_digits==2) {
            if (num<20) {
                answer = int_word.get(num);
            } else if (num%10==0) {
                answer = int_word.get(num/(int)Math.pow(10, 1) * 10);
            } else {
                answer = int_word.get(num/(int)Math.pow(10, 1) * 10) + " "
                         + numberToWordsHelper(num%10);
            }
        } else if (num_digits==1) {
            answer = int_word.get(num);
        }
        return answer;
    }
    
    public String numberToWords(int num) {
        if (num==0) return "Zero";
        int_word.put(1, "One");
        int_word.put(2, "Two");
        int_word.put(3, "Three");
        int_word.put(4, "Four");
        int_word.put(5, "Five");
        int_word.put(6, "Six");
        int_word.put(7, "Seven");
        int_word.put(8, "Eight");
        int_word.put(9, "Nine");
        int_word.put(10, "Ten");
        int_word.put(11, "Eleven");
        int_word.put(12, "Twelve");
        int_word.put(13, "Thirteen");
        int_word.put(14, "Fourteen");
        int_word.put(15, "Fifteen");
        int_word.put(16, "Sixteen");
        int_word.put(17, "Seventeen");
        int_word.put(18, "Eighteen");
        int_word.put(19, "Nineteen");
        int_word.put(20, "Twenty");
        int_word.put(30, "Thirty");
        int_word.put(40, "Forty");
        int_word.put(50, "Fifty");
        int_word.put(60, "Sixty");
        int_word.put(70, "Seventy");
        int_word.put(80, "Eighty");
        int_word.put(90, "Ninety");
        int_word.put(100, "Hundred");
        
        return numberToWordsHelper(num);
    }
}