// 2022.05.19 midnight
// Problem Statement:
// https://leetcode.com/problems/coin-change/

// idea: recursive call with a cache
class Solution {
    public int [] cache;
    public int coinChangeHelper(List<Integer> coins_arr, int amount) {
        if (cache[amount]!=0) return cache[amount];
        if (amount==0) return 0;
        if (coins_arr.contains(amount)) {
            cache[amount] = 1;
            return 1;
        }
        int min_val = Integer.MAX_VALUE;
        for (int i=0; i<coins_arr.size(); i++) {
            if (amount-coins_arr.get(i)>=0) {
                int temp = coinChangeHelper(coins_arr, amount-coins_arr.get(i));
                if (temp!=-1) {
                    min_val = Math.min(min_val, temp+1); 
                }
            }
        }
        if (min_val==Integer.MAX_VALUE) {
            cache[amount] = -1;
            return -1;
        }
        cache[amount] = min_val;
        return min_val;
    }
    
    public int coinChange(int[] coins, int amount) {
        cache = new int [amount+1];
        cache[0] = 0;
        List<Integer> coins_arr = new ArrayList<> ();
        for (int i=0; i<coins.length; i++) {
            coins_arr.add(coins[i]);
        }
        
        if (coins_arr.contains(amount)) return 1;
        return coinChangeHelper(coins_arr, amount);
    }
}