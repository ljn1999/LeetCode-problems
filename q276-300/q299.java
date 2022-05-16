// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/bulls-and-cows/

// idea: keep track of all counts for 10 digits, 
// if not a match (bull), then a misplacement (cow), 
// but the number of cow cannot exceed the max of secret and guess
class Solution {
    public String getHint(String secret, String guess) {
        int [] secret_count_digits = new int [10]; // 0~9
        int [] guess_count_digits = new int [10]; // 0~9
        int [] match_count_digits = new int [10]; // 0~9
        int bull = 0;
        int cow = 0;
        for (int i=0; i<secret.length(); i++) {
            secret_count_digits[secret.charAt(i)-'0']++;
            guess_count_digits[guess.charAt(i)-'0']++;
            if (secret.charAt(i)==guess.charAt(i)) {
                match_count_digits[secret.charAt(i)-'0']++;
            }
        }
        
        for (int i=0; i<10; i++) {
            bull += match_count_digits[i];
            cow += Math.min(guess_count_digits[i], secret_count_digits[i])-match_count_digits[i];
        }
        return Integer.toString(bull)+"A"+Integer.toString(cow)+"B";
    }
}