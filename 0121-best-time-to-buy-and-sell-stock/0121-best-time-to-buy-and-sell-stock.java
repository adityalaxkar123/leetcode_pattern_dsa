class Solution {
    public int helper(int []arr,int i,int curr,int []dp){
        if(i<0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        if(arr[i]<curr){
            dp[i] = Math.max(curr-arr[i],helper(arr,i-1,curr,dp));
        }
        else{
            dp[i] = helper(arr,i-1,arr[i],dp);
        }
        return dp[i];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(prices,n-1,-1,dp);
    }
}