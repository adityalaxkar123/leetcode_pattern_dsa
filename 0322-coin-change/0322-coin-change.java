class Solution {

    public int helper(int []coin,int amount,int idx,int [][]dp){
        if(amount==0)
            return 0;
        if(idx==0){
            if(amount%coin[idx]==0)
                return amount/coin[idx];
            return Integer.MAX_VALUE;
        }
        if(dp[idx][amount]!=-1)
            return dp[idx][amount];
        int pick=Integer.MAX_VALUE;
        if(amount>=coin[idx]){
            pick=helper(coin,amount-coin[idx],idx,dp);
            if(pick!=Integer.MAX_VALUE)
                pick+=1;
        }
        int nopick = helper(coin,amount,idx-1,dp);
        dp[idx][amount]=Math.min(pick,nopick);
        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        if(amount==0)
            return 0;
        // Arrays.sort(coins);
        int ans = helper(coins,amount,n-1,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}