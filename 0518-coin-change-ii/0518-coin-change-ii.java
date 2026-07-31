class Solution {

    public int helper(int[] coin, int amount, int idx,int [][]dp) {
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
            pick = helper(coin, amount - coin[idx], idx,dp);
        }
        int nopick = helper(coin, amount, idx - 1,dp);
        dp[idx][amount] = pick+nopick;
        return dp[idx][amount];
    }


    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        if(amount==0)
            return 1;

        return helper(coins,amount,n-1,dp);
    }
}