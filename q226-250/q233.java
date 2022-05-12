// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/number-of-digit-one/

// idea:
// 1 to 8: 1
// 9: 1
// 99: 10*[9] + 10
// 999: 10*[99] + 100
// 10: [9] + 1
// 100: [99] + 1
// 20: [19] = [10] + [9] + 9
// 30: [29] = [20] + [9]
// x0: [x0-1] = [x-1 0] + [9]
// recursion for common numbers:
// 1234: [1000] + [234] + 234
// 4321: [4000] + [321]
class Solution {
    public boolean isPowerOf10(int n) {
        double log = Math.log10(n);
        return (log % 1 == 0);
    }

    public int countDigitOneHelper(int n, int [] useful_num) {
        // base case: x00...
        if (isPowerOf10(n)) {
            return useful_num[(int) Math.log10(n)];
        } else if (n % Math.pow(10, (int) Math.log10(n))==0) {
            // return countDigitOneHelper(n-1, useful_num);
            int temp = n / (int) Math.pow(10, (int) Math.log10(n));
            return temp * useful_num[(int) Math.log10(n)] - (temp-1) 
                   + ((n-1)%(int) Math.pow(10, (int) Math.log10(n)));
        }
        
        // if n not start at 1
        int temp = (int) Math.log10(n);
        if ((int) n/(int) Math.pow(10, temp)!=1) {
            return countDigitOneHelper(n - n%(int) Math.pow(10, temp), useful_num) 
                   + countDigitOneHelper(n%(int) Math.pow(10, temp), useful_num);
        }
        
        // if start at 1
        return countDigitOneHelper(n - n%(int) Math.pow(10, temp), useful_num) 
               + countDigitOneHelper(n%(int) Math.pow(10, temp), useful_num)
               + n%(int) Math.pow(10, temp);
    }
    
    public int countDigitOne(int n) {
        if (n==0) return 0;
        int num_digits = (int) Math.log10(n) + 1; // 1234 4
        int [] useful_num = new int [num_digits]; // 10^0, 10^1, ... 10^n, n+1 in total
        for (int i=0; i<num_digits; i++) {
            if (i==0) {
                useful_num[i] = 1;
            } else {
                useful_num[i] = 10*(useful_num[i-1]-1) + (int) Math.pow(10, i-1) + 1;
            }
        }
        return countDigitOneHelper(n, useful_num);
    }
}
    /* Memory Limit Exceed
    public int countDigitOne(int n) {
        if (n==0) return 0;
        int [] dp = new int [n];
        for (int i=0; i<n; i++) {
            if (i>=0 && i<=8) {
                dp[i] = 1;
            } else if (isPowerOf10(i+1+1)) { // i+1 is 99...
                int temp1 = (int) Math.log10(i+1);
                int temp2 = (i+1) % (int) Math.pow(10, temp1);
                dp[i] = 10*dp[temp2-1] + (int) Math.pow(10, temp1);
            } else if (isPowerOf10(i+1)) { // i+1 is 100...
                dp[i] = dp[i-1] + 1;
            } else if ((i+1)%(Math.pow(10, (int) Math.log10(i+1)))==0) { // i+1 is x00...
                dp[i] = dp[i-1];
            } else {
                int temp = (int) Math.log10(i+1);
                if ((int) i/(int) Math.pow(10, temp)==1) {
                    dp[i] = i+1 - (int) Math.pow(10, temp);
                }
                dp[i] = dp[i] + dp[(i+1)-(i+1)%(int) Math.pow(10, temp)-1] 
                        + dp[(i+1)%(int) Math.pow(10, temp)-1];
            }
        }
        return dp[n-1];
    }
} */