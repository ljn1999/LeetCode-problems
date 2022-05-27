// 2022.05.26
// Problem Statement:
// https://leetcode.com/problems/coin-change-2/

// idea: 
// a better idea: dp[i][j] (use first i coins to make amount j) = dp[i-1][j] (do not use coin i to make amount j)
// + dp[i][j-coins[i-1]] (do use coin i for at least once, and the rest j-coins[i-1] is made by all i coins)
// https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
class Solution {
    public int [][] cache;
    public int changeHelper(int amount, int[] coins) {
        int length = coins.length;
        // base case 1
        if (amount==0) {
            return 1;
        }
        // already calculated
        if (cache[amount-1][length-1]!=-1) {
            return cache[amount-1][length-1];
        }
        // remove the impossible ones
        int pos = -1;
        for (int i=0; i<coins.length; i++) {
            if (coins[i]>amount) {
                pos = i;
                break;
            }
        }
        // even the smallest coin is larger than amount, no solution
        if (pos==0) {
            cache[amount-1][length-1] = 0;
            return 0;
        }
        // truncate the coins array
        if (pos!=-1) {
            coins = Arrays.copyOfRange(coins, 0, pos);
        }
        // base case 2
        if (coins.length==1) {
            if (amount%coins[0]==0) {
                cache[amount-1][length-1] = 1;
                return 1;
            }
            cache[amount-1][length-1] = 0;
            return 0;
        }
        // dfs with cache
        int max = coins[coins.length-1];
        int answer = 0;
        for (int i=0; i<=amount/max; i++) {
            answer += changeHelper(amount-i*max, Arrays.copyOfRange(coins, 0, coins.length-1));
        }
        cache[amount-1][length-1] = answer; // store into the cache
        return answer;
    }
    
    public int change(int amount, int[] coins) {
        // x = n/max
        // dp[n] = sum(change(n-ax, coins[:-1]))

        // initialize cache
        cache = new int [amount][coins.length];
        for (int i=0; i<amount; i++) {
            for (int j=0; j<coins.length; j++) {
                cache[i][j] = -1;
            }
        }

        // base case 1
        if (amount==0) return 1;

        // sort coins and the coin that is larger than the amount does not matter
        Arrays.sort(coins);
        int pos = -1;
        for (int i=0; i<coins.length; i++) {
            if (coins[i]>amount) {
                pos = i;
                break;
            }
        }
        // even the smallest coin is larger than amount, no solution
        if (pos==0) return 0;
        // truncate the coins array
        if (pos!=-1) {
            coins = Arrays.copyOfRange(coins, 0, pos);
        }

        // base case 2
        if (coins.length==1) {
            if (amount%coins[0]==0) return 1;
            return 0;
        }

        // dfs with cache
        int max = coins[coins.length-1];
        int answer = 0;
        for (int i=0; i<=amount/max; i++) {
            answer += changeHelper(amount-i*max, Arrays.copyOfRange(coins, 0, coins.length-1));
        }
        return answer;
    }
}