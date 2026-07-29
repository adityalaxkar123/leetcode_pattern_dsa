class Solution {

    // public int helper(int n,int []dp){
    //     if(n==1 || n == 0){
    //         dp[n]=1;
    //         return dp[n];
    //     }

    //     if(dp[n]!=-1)
    //         return dp[n];

    //     dp[n]=helper(n-1,dp)+helper(n-2,dp);

    //     return dp[n];
    // }

    public int climbStairs(int n) {
        // int []dp = new int[n+1];
        
        // Arrays.fill(dp,-1);
        // // // helper(n,dp);
        // dp[0]=1;
        // dp[1]=1;
        int prev = 1;
        int curr = 1;
        for(int i=2;i<n+1;i++){
            int temp = prev;
            prev = curr;
            curr = temp + curr;
        }
        return curr;
    }
}