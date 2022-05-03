// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/count-primes/

// idea: "Sieve of Eratosthenes", 
// when encounter a prime number, fill its multiples in the array
class Solution {
    public int countPrimes(int n) {
        if (n==0 || n==1) return 0;
        int answer = 0;
        boolean [] notPrime = new boolean [n-1];
        for (int i=1; i<n-1; i++) { // number = i+1
            if (notPrime[i] == false) {
                answer = answer+1;
                // fill
                for (int j=1; j<=((n-1)/(i+1)); j++) {
                    notPrime[j*(i+1)-1] = true;
                }
            }
        }
        return answer;
    }
}