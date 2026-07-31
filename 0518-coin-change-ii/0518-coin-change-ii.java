class Solution {

    public int helper(int[] coin, int amount, int idx, int[][] dp) {
        if (amount == 0)
            return 1;
        if (idx == 0) {
            if (amount % coin[idx] == 0)
                return 1;
            return 0;
        }
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int pick = 0;
        if (amount >= coin[idx]) {
            pick = helper(coin, amount - coin[idx], idx, dp);
        }
        int nopick = helper(coin, amount, idx - 1, dp);
        dp[idx][amount] = pick + nopick;
        return dp[idx][amount];
    }

    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        // for(int i=0;i<n;i++)
        //     Arrays.fill(dp[i],-1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int pick = 0;
                if (j >= coins[i]) {
                    pick = dp[i][j-coins[i]];
                }
                int nopick = dp[i-1][j];
                dp[i][j] = pick + nopick;
            }
        }

        // return helper(coins,amount,n-1,dp);
        return dp[n-1][amount];
    }
}