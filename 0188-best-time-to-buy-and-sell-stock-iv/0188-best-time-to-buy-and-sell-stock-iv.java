class Solution {
    public int helper(int []arr,int idx,int buy,int lock,int [][][]dp){
        if(idx>=arr.length || lock==-1)
            return 0;
        if(dp[idx][buy][lock]!=-1)
            return dp[idx][buy][lock];
        int pick = 0;
        if(buy==1){
            pick = -arr[idx] + helper(arr,idx+1,0,lock,dp);
        }
        else{
            pick = arr[idx]+helper(arr,idx+1,1,lock-1,dp);
        }
        int nopick = helper(arr,idx+1,buy,lock,dp);
        dp[idx][buy][lock]=Math.max(pick,nopick);
        return dp[idx][buy][lock];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][]dp = new int[n][2][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return helper(prices,0,1,k-1,dp);
    }
}