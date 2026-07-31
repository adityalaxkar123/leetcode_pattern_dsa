class Solution {

    // public int helper(int[] coin, int amount, int idx, int[][] dp) {
    //     if (amount == 0)
    //         return 1;
    //     if (idx == 0) {
    //         if (amount % coin[idx] == 0)
    //             return 1;
    //         return 0;
    //     }
    //     if (dp[idx][amount] != -1)
    //         return dp[idx][amount];
    //     int pick = 0;
    //     if (amount >= coin[idx]) {
    //         pick = helper(coin, amount - coin[idx], idx, dp);
    //     }
    //     int nopick = helper(coin, amount, idx - 1, dp);
    //     dp[idx][amount] = pick + nopick;
    //     return dp[idx][amount];
    // }

    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        int n = coins.length;
        int []prev = new int[amount+1];
        prev[0]=1;

        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int []curr = new int[amount+1];
            curr[0]=1;
            for (int j = 1; j <= amount; j++) {
                int pick = 0;
                if (j >= coins[i]) {
                    pick = curr[j-coins[i]];
                }
                int nopick = prev[j];
                curr[j] = pick + nopick;
            }
            prev=curr;
        }
        return prev[amount];
    }
}