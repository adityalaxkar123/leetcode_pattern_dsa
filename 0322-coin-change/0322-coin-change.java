class Solution {

    // public int helper(int[] coin, int amount, int idx, int[][] dp) {
    //     if (amount == 0)
    //         return 0;
    //     if (idx == 0) {
    //         if (amount % coin[idx] == 0)
    //             return amount / coin[idx];
    //         return Integer.MAX_VALUE;
    //     }
    //     if (dp[idx][amount] != -1)
    //         return dp[idx][amount];
    //     int pick = Integer.MAX_VALUE;
    //     if (amount >= coin[idx]) {
    //         pick = helper(coin, amount - coin[idx], idx, dp);
    //         if (pick != Integer.MAX_VALUE)
    //             pick += 1;
    //     }
    //     int nopick = helper(coin, amount, idx - 1, dp);
    //     dp[idx][amount] = Math.min(pick, nopick);
    //     return dp[idx][amount];
    // }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        // int[][] dp = new int[n][amount + 1];
        int []prev = new int[amount+1];
        prev[0]=0;
        for (int i = 1; i <= amount; i++) {
            if (i%coins[0] == 0)
                prev[i] = i/coins[0];
            else
                prev[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            int []curr = new int[amount+1];
            curr=prev;
            for (int j = 1; j <= amount; j++) {
                int pick = Integer.MAX_VALUE;
                if (j >= coins[i]) {
                    pick = curr[j-coins[i]];
                    if (pick != Integer.MAX_VALUE)
                        pick += 1;
                }
                int nopick = prev[j];
                curr[j] = Math.min(pick, nopick);
            }
            prev=curr;
        }

        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }
}